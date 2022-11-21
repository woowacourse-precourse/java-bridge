package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.view.InputView;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        InputView.readBridgeSize();
        new Bridge();
        bridgeGame.start();
    }
}
