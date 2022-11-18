package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridge;
    private int count;
    private int totalNumberOfAttempts;

    public BridgeGame() {
        this.count = 0;
        this.totalNumberOfAttempts = 1;
    }

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public int getCount() {
        return count;
    }

    public int getTotalNumberOfAttempts() {
        return totalNumberOfAttempts;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moving) {
        if (bridge.get(count).equals(moving)) {
            count++;
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        count = 0;
        totalNumberOfAttempts++;
        if (gameCommand.equals("R")) {
            return true;
        }
        return false;
    }

    public boolean isGameContinue() {
        if (bridge.size() > count) {
            return true;
        }
        return false;
    }
}
