package bridge.model;

import bridge.data.Moving;
import bridge.data.Pass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private final List<String> userBridge;
    private final List<List<String>> movingMap;
    private int tryCount;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.userBridge = new ArrayList<>();
        this.movingMap = new ArrayList<>(Arrays.asList(new ArrayList<>(), new ArrayList<>()));
        this.tryCount = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moving) {
        int position = userBridge.size();
        userBridge.add(moving);

        String bridgeValue = bridge.get(position);
        String passStatus = pass(moving, bridgeValue);
        movingMap.get(getMovingStatus(moving).get(0).ordinal()).add(passStatus);
        movingMap.get(getMovingStatus(moving).get(1).ordinal()).add(Pass.NOTHING.getLabel());
        return bridgeValue.equals(moving);
    }

    public boolean allPass() {
        return userBridge.equals(bridge);
    }

    public List<List<String>> getMovingMap() {
        return movingMap;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        userBridge.clear();
        movingMap.clear();
        tryCount += 1;
    }

    public int getTryCount() {
        return tryCount;
    }

    private String pass(String user, String bridge) {
        if (user.equals(bridge)) {
            return Pass.YES.getLabel();
        }
        return Pass.NO.getLabel();
    }

    private List<Moving> getMovingStatus(String moving) {
        if (moving.equals(Moving.DOWN.getLabel())) {
            return List.of(Moving.DOWN, Moving.UP);
        }
        return List.of(Moving.UP, Moving.DOWN);
    }
}
