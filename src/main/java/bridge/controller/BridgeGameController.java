package bridge.controller;

import bridge.domain.BridgeGame;
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
        BridgeGame bridgeGame = new BridgeGame(bridgeSize);
        bridgeGame.increaseGameCount();
        int movingIndex = 0;

        while (movingIndex < bridgeSize) {
            movingIndex = play(bridgeGame, movingIndex);
        }
        outputView.printResult(bridgeGame.getBridgeGameResult());
    }

    private int play(BridgeGame bridgeGame, int movingIndex) {
        String movingResult = move(bridgeGame, movingIndex);
        outputView.printMap(bridgeGame.getBridgeGameResult());
        return updateMovingIndex(bridgeGame, movingResult, movingIndex);
    }

    private int updateMovingIndex(BridgeGame bridgeGame, String movingResult, int movingIndex){
        if (bridgeGame.isMove(movingResult)) {
            return movingIndex + 1;
        }
        if (isRetry(bridgeGame)) {
            return 0;
        }
        return Integer.MAX_VALUE;
    }

    private String move(BridgeGame bridgeGame, int movingIndex) {
        String moving = inputView.readMoving();
        return bridgeGame.move(moving, movingIndex);
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