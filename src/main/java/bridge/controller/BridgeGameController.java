package bridge.controller;

import bridge.common.Result;
import bridge.domain.Player;
import bridge.dto.MoveResultDto;
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
        Result result = playBridgeGame(new Player());
        endGame(result);
    }
    private void initGame() {
        outputView.printGameStartMessage();
        int size = repeatRead(inputView::readBridgeSize);
        bridgeGameService.initBridgeGame(size);
    }

    private Result playBridgeGame(Player player) {
        while (bridgeGameService.isPlaying()) {
            crossBridge(player);
            checkRetrial(player);
        }
        return generateResult(player);
    }

    private void crossBridge(Player player) {
        String move = repeatRead(inputView::readMoving);
        MoveResultDto moveResultDto = bridgeGameService.play(player, move);
        outputView.printMap(moveResultDto);
    }

    private Result generateResult(Player player) {
        return bridgeGameService.gameOver(player);
    }
    
    private void checkRetrial(Player player) {
        if (bridgeGameService.isPlaying() || bridgeGameService.isGameOver(player)) {
            return;
        }
        String command = repeatRead(inputView::readGameCommand);
        bridgeGameService.retry(player, command);
    }

    private void endGame(Result result) {
        outputView.printResult(result);
    }

    private <T> T repeatRead(Supplier<T> reader) {
        try {
            return reader.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return repeatRead(reader);
        }
    }
}
