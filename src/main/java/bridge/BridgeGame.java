package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> userLog;
    private static int retryCount = 1;

    public BridgeGame() {
        this.userLog = new ArrayList<>();
    }

    public List<String> getUserLog() {
        return userLog;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> move(String movement) {
        userLog.add(movement);
        return userLog;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String userCommand) {
        if (userCommand.equals(Command.RETRY.getValue())) {
            userLog.remove(userLog.size() - 1);
            retryCount++;
            return true;
        }

        return false;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public boolean isOver(Bridge bridge) {
        if (bridge.getBridge().equals(userLog)) {
            return true;
        }

        return false;
    }

    public boolean isUserDead(Bridge bridge) {
        int lastBlockNumber = userLog.size() - 1;

        if (userLog.get(lastBlockNumber).equals(bridge.getBridge().get(lastBlockNumber))) {
            return false;
        }

        return true;
    }
}
