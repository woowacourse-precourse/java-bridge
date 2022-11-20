package bridge;

import bridge.controller.BridgeGame;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.createBridge();
        do {
            int position = 0;
            while (bridgeGame.move(position)) {
                position++;
            }
        } while (bridgeGame.retry());

    }
}
