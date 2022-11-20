package bridge;

import bridge.controller.BridgeController;
import bridge.controller.BridgeGameController;
import bridge.controller.PlayerController;

public class Application {
    private static final BridgeGameController bridgeGameController = new BridgeGameController();
    private static final PlayerController playerController = new PlayerController();
    private static final BridgeController bridgeController = new BridgeController();

    public static void main(String[] args) {
        init();
        playGame();
    }

    private static void init() {
        bridgeGameController.generateBridgeGame();
        bridgeController.generateBridge();
        playerController.generatePlayer();
    }

    private static boolean startCrossing(int bridgeSize) {
        String movingDirection = playerController.getMovingDirection();
        int currentDistance = playerController.getCurrentDistance();
        boolean movingSuccess = bridgeController.isPassable(currentDistance, movingDirection);
        bridgeGameController.crossBridge(movingDirection, movingSuccess);

        if (currentDistance + 1 == bridgeSize || !movingSuccess) {
            return movingSuccess;
        }
        return startCrossing(bridgeSize);
    }

    private static boolean playGame() {
        boolean gameResult = startCrossing(bridgeController.getBridgeSize());
        if (!gameResult && playerController.retryGame()) {
            bridgeGameController.retryGame();
            return playGame();
        }
        bridgeGameController.printResult(gameResult);
        playerController.printGameStatics();
        return gameResult;
    }
}
