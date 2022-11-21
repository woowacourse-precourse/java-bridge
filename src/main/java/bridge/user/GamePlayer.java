package bridge.user;

import bridge.config.NumberGeneratorDependencyContainer;
import bridge.controller.BridgeGameManager;

public class GamePlayer {

    private BridgeGameManager bridgeGameManager;

    public GamePlayer(NumberGeneratorDependencyContainer numberGeneratorDependencyContainer) {
        bridgeGameManager = new BridgeGameManager(numberGeneratorDependencyContainer);
    }

    public void playGame() {
        try {
            bridgeGameManager.setUpGame();
            move();
        } catch (IllegalArgumentException illegalArgumentException) {
            bridgeGameManager.exceptionalGameEnd(illegalArgumentException.getMessage());
            return;
        }
        bridgeGameManager.printResult();
    }

    public void move() {
        do {
            bridgeGameManager.move();
        } while (bridgeGameManager.isGameEnd());
    }

}

