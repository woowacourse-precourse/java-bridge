package bridge.controller;

import static bridge.domain.ClearInfo.ClEAR;
import static bridge.domain.ClearInfo.NOT;

import bridge.domain.BridgeSize;
import bridge.domain.MoveCommand;
import bridge.domain.ReGameCommand;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
    }

    public void run() {
        startGame();
        insertBridgeSize();
        boolean isGameClear = operate();
        endGame(isGameClear);
    }

    private void endGame(boolean isGameOver) {
        outputView.printFinalScoreMessage();
        outputView.printMap(bridgeGame.printBridge());
        outputView.printResult(bridgeGame.getRetryCount(), clearOrNot(isGameOver));
    }

    private String clearOrNot(boolean isGameClear) {
        if (isGameClear) {
            return ClEAR.getMessage();
        }
        return NOT.getMessage();
    }

    private boolean operate() {
        boolean isRetry = true;
        boolean isClear = false;
        do {
            boolean correct = playGame();
            isRetry = retryGame(correct);
            isClear = bridgeGame.isClear();
        } while (isRetry && !isClear);
        return isRetry;
    }

    private boolean retryGame(boolean correct) {
        if (!correct) {
            String command = insertReGameCommand();
            return bridgeGame.retry(command);
        }
        return true;
    }

    private String insertReGameCommand() {
        try {
            String command = inputView.readGameCommand();
            return new ReGameCommand(command).getCommand();
        } catch (IllegalArgumentException ie) {
            outputView.printErrorMessage(ie.getMessage());
            return insertReGameCommand();
        }
    }

    private boolean playGame() {
        String nextMove = insertMoveCommand();
        bridgeGame.move(nextMove);
        bridgeGame.drawBridge(nextMove);
        outputView.printMap(bridgeGame.printBridge());
        return bridgeGame.isCorrect(nextMove);
    }

    private String insertMoveCommand() {
        try {
            String command = inputView.readMoving();
            return new MoveCommand(command).getCommand();
        } catch (IllegalArgumentException ie) {
            outputView.printErrorMessage(ie.getMessage());
            return insertMoveCommand();
        }
    }

    private void insertBridgeSize() {
        try {
            String size = inputView.readBridgeSize();
            bridgeGame.createBridge(new BridgeSize(size));
        } catch (IllegalArgumentException ie) {
            outputView.printErrorMessage(ie.getMessage());
            insertBridgeSize();
        }
    }

    private void startGame() {
        outputView.printStartMessage();
    }
}
