package bridge;

import bridge.controller.MoveController;
import bridge.controller.ReadyController;
import bridge.controller.RetryController;
import bridge.type.PositionType;

public class BridgeGame {
    private final ReadyController readyController = new ReadyController();
    private final MoveController moveController = new MoveController();
    private final RetryController retryController = new RetryController();

    public void ready() {
        this.readyController.printGameIntroduce();

        int bridgeSize = this.readyController.askBridgeSize();
        this.readyController.buildBridge(bridgeSize);
    }

    public boolean move() {
        this.moveController.initializeTread();
        this.askDestinationRepeatedly();

        return this.moveController.getMoveResult();
    }

    private void askDestinationRepeatedly() {
        boolean canContinue = true;

        while (canContinue) {
            PositionType position = this.moveController.askDestination();
            canContinue = this.moveController.moveToDestination(position);
        }
    }

    public boolean retry(boolean isPass) {
        boolean isRetry = this.retryController.askToRetryAndQuitAfterReturnIsRetry(isPass);

        if (!isRetry) {
            this.retryController.printGameMapAndStatus(isPass);
        }

        return isRetry;
    }
}
