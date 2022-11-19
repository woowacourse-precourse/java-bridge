package bridge;

import enumCollections.GuideMessage;

public class Controller {
    public void startGame(BridgeGame bridgeGame) {
        bridgeGame.generateBridge(getBridgeSize());
    }

    private int getBridgeSize() {
        new OutputView().printGuideMessage(GuideMessage.START);
        return new InputView().readBridgeSize();
    }
}
