package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private List<String> upBridge;
    private List<String> downBridge;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.upBridge = new ArrayList<>();
        upBridge.add("[");
        this.downBridge = new ArrayList<>();
        downBridge.add("[");
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getUpBridge() {
        return upBridge;
    }

    public List<String> getDownBridge() {
        return downBridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction, int index) {
        String validBridge = bridge.get(index);
        DirectionType directionType = DirectionType.valueOf(direction);
        String[] moveResult = initializeMovingResult(direction, validBridge, directionType);
        addBridge(moveResult, index);
    }

    private void addBridge(String[] moveResult, int index) {
        downBridge.add(moveResult[0]);
        upBridge.add(moveResult[1]);
        downBridge.add("|");
        upBridge.add("|");
        if (index == bridge.size()) {
            downBridge.add("]");
            upBridge.add("]");
        }
    }

    private String[] initializeMovingResult(String direction, String validBridge, DirectionType directionType) {
        final String X = " X ";
        final String O = " O ";
        final String SPACE = "   ";
        String[] moveResult = {SPACE, SPACE};
        moveResult[directionType.getNumber()] = X;
        if (Objects.equals(direction, validBridge)) {
            moveResult[directionType.getNumber()] = O;
        }
        return moveResult;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
