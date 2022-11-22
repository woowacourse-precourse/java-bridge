package bridge;

import bridge.bridgeGame.BridgeGame;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();

        try {
            BridgeGame bridgeGame = controller.prepareBridgeGame();
            controller.startBridgeGame(bridgeGame);
        } catch (IllegalArgumentException iae) {
            return;
        }
    }

}
