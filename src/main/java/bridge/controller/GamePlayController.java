package bridge.controller;

import bridge.*;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GamePlayController {
    private final static String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void createBridgeGame() {
        BridgeGame bridgeGame;
        while (true) {
            try {
                int bridgeSize = inputView.readBridgeSize();
                bridgeGame = createBridgeGame(bridgeSize);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_MESSAGE_PREFIX + e.getMessage());
            }
        }
        moveUser(bridgeGame);
    }

    private BridgeGame createBridgeGame(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
//                Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        return new BridgeGame(bridgeMaker.makeBridge(bridgeSize));
    }

    public void moveUser(BridgeGame bridgeGame) {
        while (true) {
            try {
                char moveCommand = inputView.readMoveCommand();
                MoveResult moveResult = bridgeGame.move(moveCommand);
                outputView.printMap(moveResult);

                if (isEndGame(moveResult, bridgeGame)) {
                    return;
                }

            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_MESSAGE_PREFIX + e.getMessage());
            }
        }
    }

    private boolean isEndGame(MoveResult moveResult, BridgeGame bridgeGame) {
        GameStatus gameStatus = moveResult.getMoveStatus();
        if (gameStatus == GameStatus.FAIL) {
            return !retry(bridgeGame, moveResult);
        }
        if (gameStatus == GameStatus.CORRECT) {
            outputView.printResult(moveResult, bridgeGame);
            return true;
        }
        return false;
    }

    public boolean retry(BridgeGame bridgeGame, MoveResult moveResult) {
        while (true) {
            try {
                char retryCommand = inputView.readRetryCommand();

                if (retryCommand == RetryCommand.QUIT.getValue()) {
                    outputView.printResult(moveResult, bridgeGame);
                    return false;
                }

                if (retryCommand == RetryCommand.RETRY.getValue()) {
                    bridgeGame.retry();
                    return true;
                }

            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_MESSAGE_PREFIX + e.getMessage());
            }
        }
    }
}
