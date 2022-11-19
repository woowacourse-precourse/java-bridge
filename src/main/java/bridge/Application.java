package bridge;

import bridge.controller.BridgeController;
import bridge.controller.BridgeGameController;
import bridge.controller.PlayerController;
import bridge.view.OutputView;

public class Application {
    private static final BridgeGameController bridgeGameController = new BridgeGameController();
    private static final PlayerController playerController = new PlayerController();
    private static final BridgeController bridgeController = new BridgeController();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.startGame();
        bridgeGameController.generateBridgeGame();
        bridgeController.generateBridge();
        playerController.generatePlayer();

        String movingDirection = playerController.getMovingDirection();
        int currentDistance = playerController.getCurrentDistance();
        boolean passResult = bridgeController.isPassable(currentDistance, movingDirection);
    }
}
