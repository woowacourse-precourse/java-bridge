package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeGameResult;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void GameRun() {
        outputView.printGameStart();
        int bridgeSize = inputView.readBridgeSize();
        BridgeGameResult bridgeGameResult = play(bridgeSize);
        outputView.printResult(bridgeGameResult);
    }

    private BridgeGameResult play(int bridgeSize) {
        BridgeGame bridgeGame = new BridgeGame(bridgeSize);
        int movingIndex = 0;
        bridgeGame.increaseGameCount();

        while(movingIndex < bridgeSize) {
            String movingResult = move(bridgeGame, movingIndex);
            boolean isMove = bridgeGame.isMove(movingResult);
            movingIndex = updateMovingIndex(isMove, movingIndex);
            if (!isContinue(bridgeGame, isMove)) {
                break;
            }
        }
        return bridgeGame.getBridgeGameResult();
    }

    private String move(BridgeGame bridgeGame, int movingIndex) {
         String moving = inputView.readMoving();
         String movingResult = bridgeGame.move(moving, movingIndex);
         outputView.printMap(bridgeGame.getBridgeGameResult());
         return movingResult;
    }

    private int updateMovingIndex(boolean isMove, int movingIndex) {
        if (isMove) {
            return movingIndex + 1;
        }
        return 0;
    }

    private boolean isContinue(BridgeGame bridgeGame, boolean isMove) {
        if (isMove) {
            return true;
        }
        return isRetry(bridgeGame);
    }

    private boolean isRetry(BridgeGame bridgeGame) {
        String gameCommand = inputView.readGameCommand();
        if (bridgeGame.isRetry(gameCommand)) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }
}
