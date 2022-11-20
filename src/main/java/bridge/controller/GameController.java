package bridge.controller;

import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public GameController(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }

    public void start() {
        outputView.startGame();
        int bridgeSize = createBridge();
        try {
            moveUserOnBridge(bridgeSize);
        } catch (IllegalStateException | IllegalArgumentException exception) {
            outputView.printResult(exception.getMessage());
        }
    }

    private int createBridge() {
        int bridgeSize = inputView.readBridgeSize();
        return bridgeGame.createBridge(bridgeSize);
    }

    private void moveUserOnBridge(int bridgeSize) {
        for (int attempt = 0; attempt < bridgeSize; attempt++) {
            String updateMoveResult = bridgeGame.move(inputView.readMoving(), attempt);
            outputView.printMap(updateMoveResult);
            attempt = failGame(attempt);
            finish(bridgeSize, attempt);
        }
    }

    private int failGame(int attempt) {
        if (bridgeGame.fail()) {
            bridgeGame.retry(inputView.readGameCommand());
            return -1;
        }
        return attempt;
    }

    private void finish(int bridgeSize, int attempt) {
        if (attempt == bridgeSize - 1) {
            outputView.printResult(bridgeGame.getFinishResult());
        }
    }
}
