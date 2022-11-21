package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private List<String> user;
    private int tryCounts;

    public BridgeGame(List<String> bridge) {
        this.bridge    = bridge;
        this.user      = new ArrayList<>();
        this.tryCounts = 1;
    }

    public List<String> getUser() {
        return user;
    }

    public int getTryCounts() {
        return tryCounts;
    }

    /**
     * get end game whether
     * @return 0 - not end, 1 - failure, 2 - success
     */
    public int getEndGame() {
        if (user.get(user.size()-1).length() > 1) {
            return 1;
        }
        if (user.size() == bridge.size()) {
            return 2;
        }
        return 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> move(String command) {
        String u = command;
        if (!bridge.get(user.size()).equals(command)) {
            u += "X";
        }
        user.add(u);
        return this.getUser();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.user = new ArrayList<>();
        this.tryCounts++;
    }
}
