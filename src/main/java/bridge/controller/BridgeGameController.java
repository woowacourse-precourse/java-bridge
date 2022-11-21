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
        outputView.printResult(bridgeGame.getBridgeGameResult(), bridgeGame.getBridgeGameCount());
    }

    private int play(BridgeGame bridgeGame, int movingIndex) {
        boolean moving = move(bridgeGame, movingIndex);
        outputView.printMap(bridgeGame.getBridgeGameResult());
        return updateMovingIndex(bridgeGame, moving, movingIndex);
    }

    private int updateMovingIndex(BridgeGame bridgeGame, boolean moving, int movingIndex){
        if (moving) {
            return movingIndex + 1;
        }
        if (retry(bridgeGame)) {
            return 0;
        }
        return Integer.MAX_VALUE;
    }

    private boolean move(BridgeGame bridgeGame, int movingIndex) {
        String moving = inputView.readMoving();
        return bridgeGame.move(moving, movingIndex);
    }

    private boolean retry(BridgeGame bridgeGame) {
        String gameCommand = inputView.readGameCommand();
        return bridgeGame.retry(gameCommand);
    }
}