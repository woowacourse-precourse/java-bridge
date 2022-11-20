package bridge.controller;

import bridge.*;

public class GamePlayController {
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
                System.out.println("[ERROR] " + e.getMessage());
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
                System.out.println("[ERROR] " + e.getMessage());
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

                if (retryCommand == 'Q') {
                    outputView.printResult(moveResult, bridgeGame);
                    return false;
                }

                if(retryCommand == 'R'){
                    bridgeGame.retry();
                    return true;
                }
                
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
}
