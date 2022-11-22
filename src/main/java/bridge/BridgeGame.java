package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private int location;
    private boolean moveSuccess;

    private int totalGameCount;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        location = 0;
        moveSuccess = true;
        totalGameCount = 1;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int getLocation() {
        return location;
    }

    public int getTotalGameCount() {
        return totalGameCount;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moveCommand) {
        if (bridge.get(location).equals(moveCommand)) {
            location++;
            return;
        }
        moveSuccess = false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        if (gameCommand.equals(CommandConstant.RETRY_COMMAND)) {
            location = 0;
            moveSuccess = true;
            totalGameCount++;
            return true;
        }
        return false;
    }

    public boolean isGameEnd() {
        if (bridge.size() == location) {
            return true;
        }
        return false;
    }

    public boolean succeedMove() {
        return moveSuccess;
    }
}
