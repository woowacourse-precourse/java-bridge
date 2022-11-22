package bridge;

import bridge.controller.BridgeGame;
import bridge.domain.Command;
import bridge.domain.Status;

public class Application {
    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.start();
        Status status;
        do {
            status = bridgeGame.move();
        } while (status != Status.SUCCESS && bridgeGame.retry() != Command.QUIT);
        bridgeGame.finish(status);
    }
}
