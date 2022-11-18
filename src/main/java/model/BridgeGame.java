package model;

import static bridge.enums.BridgeElement.BRIDGE_EMPTY_ELEMENT;
import static bridge.enums.BridgeElement.BRIDGE_PASSABLE_ELEMENT;
import static bridge.enums.BridgeElement.BRIDGE_IMPASSABLE_ELEMENT;
import static bridge.enums.Direction.UPWARD_DIRECTION;
import static bridge.enums.Direction.DOWNWARD_DIRECTION;

import bridge.enums.Direction;
import java.util.ArrayList;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge answerBridge;


    private final Bridge upperBridge;
    private final Bridge lowerBridge;

    public BridgeGame(Bridge answerBridge) {
        this.answerBridge = answerBridge;
        upperBridge = new Bridge(new ArrayList<>());
        lowerBridge = new Bridge(new ArrayList<>());
    }

    public Bridge getUpperBridge() {
        return upperBridge;
    }

    public Bridge getLowerBridge() {
        return lowerBridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String direction) {
        int index = upperBridge.size();
        String answerDirection = answerBridge.get(index);
        boolean correct = answerDirection.equals(direction);
        Direction consistentEnum = Objects.requireNonNull(Direction.getEnum(direction));

        setUpperBridge(correct, consistentEnum);
        setLowerBridge(correct, consistentEnum);
        return correct;
    }

    private void setUpperBridge(boolean correct, Direction direction) {
        if (direction.equals(DOWNWARD_DIRECTION)) {
            upperBridge.add(BRIDGE_EMPTY_ELEMENT);
        }
        if (direction.equals(UPWARD_DIRECTION) && correct) {
            upperBridge.add(BRIDGE_PASSABLE_ELEMENT);
        }
        if (direction.equals(UPWARD_DIRECTION) && !correct) {
            upperBridge.add(BRIDGE_IMPASSABLE_ELEMENT);
        }
    }

    private void setLowerBridge(boolean correct, Direction direction) {
        if (direction.equals(UPWARD_DIRECTION)) {
            lowerBridge.add(BRIDGE_EMPTY_ELEMENT);
        }
        if (direction.equals(DOWNWARD_DIRECTION) && correct) {
            lowerBridge.add(BRIDGE_PASSABLE_ELEMENT);
        }
        if (direction.equals(DOWNWARD_DIRECTION) && !correct) {
            lowerBridge.add(BRIDGE_IMPASSABLE_ELEMENT);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
