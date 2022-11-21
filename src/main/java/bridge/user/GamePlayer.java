package bridge.user;

import bridge.config.NumberGeneratorDependencyContainer;
import bridge.controller.BridgeGameController;

public class GamePlayer {

    private BridgeGameController bridgeGameController;

    public GamePlayer(NumberGeneratorDependencyContainer numberGeneratorDependencyContainer) {
        bridgeGameController = new BridgeGameController(numberGeneratorDependencyContainer);
    }

    public void playGame() {
        try {
            bridgeGameController.setUpGame();
            move();
        } catch (IllegalArgumentException illegalArgumentException) {
            bridgeGameController.exceptionalGameEnd(illegalArgumentException.getMessage());
            return;
        }
        bridgeGameController.printResult();
    }

    public void move() {
        do {
            bridgeGameController.move();
        } while (bridgeGameController.GameKeepGoingOrNot());
    }

}

