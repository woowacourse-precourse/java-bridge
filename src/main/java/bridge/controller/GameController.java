package bridge.controller;

import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.PassingSpace;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public BridgeGame createBridgeGame(Bridge bridge) {
        PassingSpace passingSpace = new PassingSpace();
        return new BridgeGame(bridge, passingSpace);
    }

    public void run(BridgeGame bridgeGame) {
        do {
            runRound(bridgeGame);
        } while (continueGame(bridgeGame));
        printResult(bridgeGame);
    }

    private boolean continueGame(BridgeGame bridgeGame) {
        if (bridgeGame.isSuccessCrossingBridge()) {
            return false;
        }
        return bridgeGame.retry(selectRetryGame());
    }

    private void printResult(BridgeGame bridgeGame) {
        String drawing = bridgeGame.drawPassingSpace();
        boolean isSuccess = bridgeGame.isSuccessCrossingBridge();
        outputView.printResult(drawing, isSuccess, bridgeGame.getNumberOfTry());
    }

    private String selectRetryGame() {
        try {
            outputView.printSelectRetryOrNotInput();
            return inputView.readGameCommand();
        } catch (IllegalArgumentException illegalArgumentException) {
            illegalArgumentException.getMessage();
            return selectRetryGame();
        }
    }

    private void runRound(BridgeGame bridgeGame) {
        String moving;
        do {
            moving = selectMoving();
            bridgeGame.move(moving);
            outputView.printMap(bridgeGame.drawPassingSpace());
        } while (continueRound(bridgeGame, moving));
    }

    private boolean continueRound(BridgeGame bridgeGame, String moving) {
        return bridgeGame.isRightSpace() && !bridgeGame.isSuccessCrossingBridge();
    }

    private String selectMoving() {
        try {
            outputView.printSelectUpOrDownInput();
            String readMoving = inputView.readMoving();
            return readMoving;
        } catch (IllegalArgumentException illegalArgumentException) {
            illegalArgumentException.getMessage();
            return selectMoving();
        }
    }
}
