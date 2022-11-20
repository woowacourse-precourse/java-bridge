package bridge;

import bridge.controller.BridgeGame;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.createBridge();
        int position = 0;
        while (bridgeGame.move(position)) {
            position++;
        }
    }
}
