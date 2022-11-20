package bridge.controller;

import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.GameResultDto;
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
        outputView.printStartGame();
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
        GameResultDto gameResult = bridgeGame.getGameResult();
        outputView.printResult(gameResult);
    }

    private String selectRetryGame() {
        try {
            outputView.printSelectRetryOrNotInput();
            String selectRetryingGame = inputView.readGameCommand();
            return selectRetryingGame;
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printExceptionMessage(illegalArgumentException);
            return selectRetryGame();
        }
    }

    private void runRound(BridgeGame bridgeGame) {
        String moving;
        do {
            moving = selectMoving();
            bridgeGame.move(moving);
            outputView.printMap(bridgeGame.drawPassingSpace());
        } while (continueRound(bridgeGame));
    }

    private boolean continueRound(BridgeGame bridgeGame) {
        return bridgeGame.isRightSpace() && !bridgeGame.isSuccessCrossingBridge();
    }

    private String selectMoving() {
        try {
            outputView.printSelectUpOrDownInput();
            String readMoving = inputView.readMoving();
            return readMoving;
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printExceptionMessage(illegalArgumentException);
            return selectMoving();
        }
    }
}
