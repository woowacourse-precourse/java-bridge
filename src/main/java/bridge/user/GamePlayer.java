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
            bridgeGameController.printResult();
        } catch (IllegalArgumentException illegalArgumentException) {
            bridgeGameController.exceptionalGameEnd(illegalArgumentException.getMessage());
        }
    }

    public void move() {
        do {
            bridgeGameController.move();
        } while (bridgeGameController.GameKeepGoingOrNot());
    }
}

