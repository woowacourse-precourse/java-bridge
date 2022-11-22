package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.Attempt;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static bridge.enums.BridgeStatus.LOWER;
import static bridge.enums.BridgeStatus.UPPER;
import static bridge.enums.Space.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final List<String> upperBridges;
    private final List<String> lowerBridges;
    private Integer index;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        upperBridges = new ArrayList<>();
        lowerBridges = new ArrayList<>();
        index = 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        if (isUp(moving)) {
            addBlank(lowerBridges);
            addMatch(moving, upperBridges);
        }
        if (isLow(moving)) {
            addBlank(upperBridges);
            addMatch(moving, lowerBridges);
        }
        addIndex();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(Attempt attempt) {
        upperBridges.clear();
        lowerBridges.clear();
        index = 0;
        attempt.addCount();
    }

    boolean isUp(String str) {
        return Objects.equals(str, UPPER.getStatus());
    }

    boolean isLow(String str) {
        return Objects.equals(str, LOWER.getStatus());
    }

    void addBlank(List<String> bridge) {
        bridge.add(BLANK.getContent());
    }

    void addMatch(String moving, List<String> bridges) {
        String nextValue = bridge.getBridgeByIndex(index);
        if (Objects.equals(nextValue, moving)) {
            bridges.add(SUCCESS.getContent());
            return;
        }
        bridges.add(FAIL.getContent());
    }

    void addIndex() {
        this.index++;
    }

    public boolean isFail() {
        return isLastFail(upperBridges) || isLastFail(lowerBridges);
    }

    boolean isLastFail(List<String> bridges) {
        return bridges.isEmpty() || bridges.get(index - 1).equals(FAIL.getContent());
    }

    public List<String> getUpperBridges() {
        return upperBridges;
    }

    public List<String> getLowerBridges() {
        return lowerBridges;
    }

    public boolean isMatchBridgesSize() {
        return upperBridges.size() == bridge.getBridgeSize();
    }
}
