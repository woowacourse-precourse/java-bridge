package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public void move(UserBridge userBridge, Direction direction, Direction now) {
        if (Direction.isUp(now)) {
            userBridge.moveUpBridge(direction);
        }
        if (Direction.isDown(now)) {
            userBridge.moveDownBridge(direction);
        }

        userBridge.addBlank(now);
    }

    public boolean retry(BridgeGameManager bridgeGameManager, UserBridge userBridge, String retry) {
        if (retry.equals("R")) {
            userBridge.reset();
            bridgeGameManager.increaseCount();
            return false;
        }

        if (retry.equals("Q")) {
            return true;
        }
        return false;
    }
}