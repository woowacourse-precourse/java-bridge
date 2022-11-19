package bridge;

import bridge.domain.BridgeGame;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.start();
        boolean play = true;
        while (play) {
            boolean correct = bridgeGame.move();
            while (correct && !bridgeGame.gameSuccess()) {
                correct = bridgeGame.move();
            }
            if (bridgeGame.gameSuccess()) {
                bridgeGame.endGame();
                play = false;
            } else {
                play = bridgeGame.retry();
            }
        }
    }
}
