package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int trial = 0;
    private List<String> bridge;
    private List<String> userSteps;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String direction) {
        userSteps.add(direction);
        return userSteps.get(userSteps.size() - 1).equals(bridge.get(userSteps.size() - 1));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        System.out.println();
        userSteps = new ArrayList<>();
        trial++;
        return true;
    }

    public void buildBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getUserSteps() {
        return userSteps;
    }

    public int getTrial() {
        return trial;
    }
}
