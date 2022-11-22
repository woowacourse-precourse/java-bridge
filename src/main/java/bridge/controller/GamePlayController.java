package bridge.controller;

import bridge.*;
import bridge.domain.*;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GamePlayController {
    private final static String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    private final InputView inputView;
    private final OutputView outputView;

    public GamePlayController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        BridgeGame bridgeGame = createBridgeGame();
        moveUser(bridgeGame);
    }

    public BridgeGame createBridgeGame() {
        while (true) {
            try {
                return createBridgeGame(inputView.readBridgeSize());
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_MESSAGE_PREFIX + e.getMessage());
            }
        }
    }

    private BridgeGame createBridgeGame(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return new BridgeGame(new Bridge(bridgeMaker.makeBridge(bridgeSize)));
    }

    public void moveUser(BridgeGame bridgeGame) {
        while (true) {
            try {
                MoveResult moveResult = bridgeGame.move(inputView.readMoveCommand());
                outputView.printMap(moveResult);
                if (isEndGame(moveResult, bridgeGame)) return;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_MESSAGE_PREFIX + e.getMessage());
            }
        }
    }

    private boolean isEndGame(MoveResult moveResult, BridgeGame bridgeGame) {
        if (GameStatus.FAIL == moveResult.getGameStatus()) {
            return !retry(bridgeGame, moveResult);
        }
        if (GameStatus.CORRECT == moveResult.getGameStatus()) {
            outputView.printResult(moveResult, bridgeGame);
            return true;
        }
        return false;
    }

    public boolean retry(BridgeGame bridgeGame, MoveResult moveResult) {
        while (true) {
            try {
                RetryCommand retryCommand = inputView.readRetryCommand();
                return retryOrQuit(bridgeGame, moveResult, retryCommand);
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_MESSAGE_PREFIX + e.getMessage());
            }
        }
    }

    private boolean retryOrQuit(BridgeGame bridgeGame, MoveResult moveResult, RetryCommand retryCommand) {
        if (retryCommand == RetryCommand.QUIT) {
            outputView.printResult(moveResult, bridgeGame);
            return false;
        }
        bridgeGame.retry();
        return true;
    }
}
