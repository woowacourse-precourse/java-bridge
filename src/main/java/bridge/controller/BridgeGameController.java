package bridge.controller;

import bridge.domain.MoveResult;
import bridge.domain.Player;
import bridge.service.BridgeGameService;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;
import java.util.function.Supplier;

public class BridgeGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final BridgeGameService bridgeGameService;

    public BridgeGameController(BridgeGameService bridgeGameService) {
        this.bridgeGameService = bridgeGameService;
    }

    public void run() {
        initGame();
        Player player = new Player();
        List<List<MoveResult>> result = List.of(List.of(MoveResult.SUCCESS, MoveResult.SUCCESS, MoveResult.FAIL));
        outputView.printMap(result);
    }

    private void initGame() {
        outputView.printGameStartMessage();
        int size = repeatCommand(inputView::readBridgeSize);
        bridgeGameService.initBridgeGame(size);
    }

    private <T> T repeatCommand(Supplier<T> reader) {
        try {
            return reader.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return repeatCommand(reader);
        }
    }
}
