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
        }
        return bridgeGame.getBridgeGameResult();
    }

    private String move(BridgeGame bridgeGame, int movingIndex) {
         String moving = inputView.readMoving();
         String movingResult = bridgeGame.move(moving, movingIndex);
         outputView.printMap(bridgeGame.getBridgeGameResult());
         return movingResult;
    }
}
