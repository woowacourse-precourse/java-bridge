package bridge.controller;

import bridge.domain.Player;
import bridge.service.BridgeGameService;
import bridge.view.InputView;
import bridge.view.OutputView;
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
