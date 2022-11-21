package bridge.BridgeGameController;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.Model.BridgeGame;
import bridge.View.InputView;
import bridge.View.OutputView;

import static bridge.Message.GuideMessage.*;

public class BridgeGameController {

    private BridgeMaker bridgeMaker;

    public void init() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        System.out.println(GAME_START_MESSAGE.getGuideMessage());
        BridgeGame.setBridgeSize(InputView.readBridgeSize());
        BridgeGame.setBridgeAnswer(bridgeMaker.makeBridge(BridgeGame.getBridgeSize()));
    }

    public boolean playBridgeGame() {
        for (int currentBridgeSize = 0; currentBridgeSize < BridgeGame.getBridgeSize(); currentBridgeSize++) {
            String nextPosition = InputView.readMoving();
            BridgeGame.move(nextPosition, currentBridgeSize);
            OutputView.printMap(BridgeGame.getCurrentBridge());
            if (!BridgeGame.isSuccess()) {
                return playAgainBridgeGame();
            }
        }
        BridgeGame.increaseGameCount();
        return true;
    }

    public boolean playAgainBridgeGame() {
        String retryCommand = InputView.readGameCommand();
        boolean playAgain = BridgeGame.retry(retryCommand);
        BridgeGame.increaseGameCount();
        if (playAgain) {
            BridgeGame.resetBridge();
            return playBridgeGame();
        }
        return false;
    }
}
