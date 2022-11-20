package bridge.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge = new ArrayList<>();
    private final List<String> map = new ArrayList<>();
    private int countOfAttempts;
    private boolean needsRetry; // true 일 경우 재시도하거나 종료해야 함
    private boolean success; // true 일 경우 게임 성공

    public BridgeGame(List<String> bridge) {
        this.bridge.addAll(bridge);
        this.countOfAttempts = 1;
        this.needsRetry = false;
        this.success = false;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getMap() {
        return map;
    }

    public int getCountOfAttempts() {
        return countOfAttempts;
    }

    public boolean isNeedsRetry() {
        return needsRetry;
    }

    public boolean isSuccess() {
        return success;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
