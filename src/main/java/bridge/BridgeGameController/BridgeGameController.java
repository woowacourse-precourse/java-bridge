package bridge.BridgeGameController;

import bridge.Model.Bridge;
import bridge.Model.BridgeGame;
import bridge.View.InputView;
import bridge.View.OutputView;

import static bridge.Message.GuideMessage.*;

public class BridgeGameController {

    private Bridge bridge;
    private BridgeGame bridgeGame;

    public void init() {
        System.out.println(GAME_START_MESSAGE.getGuideMessage());
        bridge = new Bridge();
        bridgeGame = new BridgeGame();
    }

    public boolean playBridgeGame() {
        for (int currentBridgeSize = 0; currentBridgeSize < bridge.getBridgeSize(); currentBridgeSize++) {
            String nextPosition = InputView.readMoving();
            bridgeGame.move(nextPosition, currentBridgeSize, bridge);
            OutputView.printMap(bridgeGame.getCurrentBridge());
            if (!bridgeGame.isSuccess()) {
                return playAgainBridgeGame();
            }
        }
        bridgeGame.increaseGameCount();
        return true;
    }

    public boolean playAgainBridgeGame() {
        String retryCommand = InputView.readGameCommand();
        boolean playAgain = bridgeGame.retry(retryCommand);
        bridgeGame.increaseGameCount();
        if (playAgain) {
            bridgeGame.resetBridge();
            return playBridgeGame();
        }
        return false;
    }

    public void run() {
        init();
        boolean isSuccess = playBridgeGame();
        OutputView.printResult(isSuccess, bridgeGame.getGameCount(), bridgeGame.getCurrentBridge());
    }
}
