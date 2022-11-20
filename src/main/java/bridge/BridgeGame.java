package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.Validator.*;


/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private List<String> userBridgeHistroy = new ArrayList<>();
    private int movingCount;
    private int tryCount;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        tryCount++;
    }

    public boolean move(String moving) {
        validateMoving(moving);
        userBridgeHistroy.add(moving);
        if (bridge.get(movingCount).equals(moving)) {
            movingCount++;
            return true;
        }
        return false;
    }

    public boolean retry(String command) {
        validateCommand(command);
        if (command.equals("R")) {
            movingCount = 0;
            userBridgeHistroy.clear();
            tryCount++;
            return true;
        }
        return false;
    }

    public boolean checkWin() {
        if (bridge.equals(userBridgeHistroy)) {
            return true;
        }
        return false;
    }

    public List<String> getUserBridgeHistroy() {
        return userBridgeHistroy;
    }

    public int getTryCount() {
        return tryCount;
    }

}

