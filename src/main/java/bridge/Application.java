package bridge;

import bridge.controller.BridgeGame;
import bridge.domain.Bridge;
import bridge.view.BridgeView;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame(new BridgeView(), new Bridge());
        bridgeGame.startGame();
    }
}
