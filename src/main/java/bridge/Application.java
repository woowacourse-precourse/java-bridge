package bridge;

import bridge.controller.BridgeGame;
import bridge.domain.Command;
import bridge.domain.Status;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        Status status;
        bridgeGame.start();
        while (true) {
            status = bridgeGame.move();
            if (status == Status.SUCCESS) {
                break;
            }
            if (bridgeGame.retry() == Command.QUIT) {
                break;
            }
        }
        bridgeGame.finish(status);
    }
}
