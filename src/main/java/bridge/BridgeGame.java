package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> bridge;
    private List<String> currentUpBridge;
    private List<String> currentDownBridge;
    private int tryCount;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.tryCount = 1;
        initBridge();
    }

    private void initBridge() {
        this.currentUpBridge = new ArrayList<>();
        this.currentDownBridge = new ArrayList<>();
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getCurrentUpBridge() {
        return currentUpBridge;
    }

    public List<String> getCurrentDownBridge() {
        return currentDownBridge;
    }

    public int getTryCount() {
        return tryCount;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * @param movement
     * @param index
     */
    public boolean move(String movement, int index) {
        if (bridge.get(index).equals(movement)) {
            moveOorX("O", movement);
            return true;
        }
        if (!bridge.get(index).equals(movement)) {
            moveOorX("X", movement);
        }
        return false;
    }

    private void moveOorX(String ox, String movement) {
        if (movement.equals("U")) {
            currentUpBridge.add(ox);
            currentDownBridge.add(" ");
        }
        if (movement.equals("D")) {
            currentDownBridge.add(ox);
            currentUpBridge.add(" ");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param retry
     */
    public boolean retry(String retry) {
        if (retry.equals("R")) {
            this.tryCount++;
            initBridge();
            return true;
        }
        return false;
    }
}
