package bridge;

import bridge.domain.BridgeGame;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.start();
        boolean play = true;
        while (play) {
            boolean correct = bridgeGame.move();
            boolean success = bridgeGame.gameSuccess();
            while (correct && !success) {
                correct = bridgeGame.move();
                success = bridgeGame.gameSuccess();
            }
            if (success) {
                bridgeGame.endGame(true);
                play = false;
            } else {
                play = bridgeGame.retry();
            }
        }
    }
}
