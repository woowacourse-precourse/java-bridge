package bridge;

import bridge.controller.MoveController;
import bridge.controller.ReadyController;
import bridge.controller.RetryController;
import bridge.type.PositionType;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final ReadyController readyController = new ReadyController();
    private final MoveController moveController = new MoveController();
    private final RetryController retryController = new RetryController();

    public void ready() {
        this.readyController.printGameIntroduce();

        int bridgeSize = this.readyController.askBridgeSize();
        this.readyController.buildBridge(bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
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

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(boolean isPass) {
        boolean isRetry = this.retryController.askToRetryAndQuitAfterReturnIsRetry(isPass);

        if (!isRetry) {
            this.retryController.printGameMapAndStatus(isPass);
        }

        return isRetry;
    }
}
