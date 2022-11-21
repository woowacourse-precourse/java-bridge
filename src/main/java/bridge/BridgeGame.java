package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> user;
    private final List<String> bridge;
    private int attempts = 1;

    public BridgeGame(List<String> bridge) {
        this.user = new ArrayList<>();
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        user.add(moving);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        if (gameCommand.equals("R")) {
            resetGame();
            return true;
        }
        return false;
    }

    public void resetGame() {
        attempts++;
        user.clear();
    }

    public boolean isCorrect() {
        int lastIndex = user.size() - 1;
        return user.get(lastIndex).equals(bridge.get(lastIndex));
    }

    public List<String> getUser() {
        return user;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int getAttempts() {
        return attempts;
    }
}
