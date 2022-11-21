package bridge.domain;

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
        if (GameCommand.isRetry(retry)) {
            userBridge.reset();
            bridgeGameManager.increaseCount();
            return false;
        }

        if (GameCommand.isQuit(retry)) {
            return true;
        }
        return false;
    }
}