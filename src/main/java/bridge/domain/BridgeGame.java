package bridge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static bridge.domain.MoveType.X;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private List<String> upBridge;
    private List<String> downBridge;
    private boolean isQuit;
    private int index;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.upBridge = new ArrayList<>();
        upBridge.add("[");
        this.downBridge = new ArrayList<>();
        downBridge.add("[");
        this.isQuit = false;
        this.index = 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction) {
        String validBridge = bridge.get(index);
        DirectionType directionType = DirectionType.valueOfString(direction);
        MoveType[] moveResult = initializeMovingResult(validBridge, direction, directionType.getNumber());
        String downMove = moveResult[0].getValue();
        String upMove = moveResult[1].getValue();
        addBridge(downMove, upMove);
        index += 1;
    }

    private void addBridge(String downMove, String upMove) {
        downBridge.add(downMove);
        upBridge.add(upMove);
        if (!checkIsEnded()) {
            return;
        }
        downBridge.add("]");
        upBridge.add("]");
    }

    private boolean checkIsEnded() {
        if (index < bridge.size() - 1) {
            downBridge.add("|");
            upBridge.add("|");
            return false;
        }
        return true;
    }

    private MoveType[] initializeMovingResult(String validBridge, String direction, int number) {
        MoveType[] moveResult = {MoveType.SPACE, MoveType.SPACE};
        moveResult[number] = MoveType.X;
        if (Objects.equals(validBridge, direction)) {
            moveResult[number] = MoveType.O;
        }
        return moveResult;
    }

    public boolean isFailed() {
        if (upBridge.contains(X.getValue())) {
            return true;
        }
        return downBridge.contains(X.getValue());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.upBridge = new ArrayList<>();
        upBridge.add("[");
        this.downBridge = new ArrayList<>();
        downBridge.add("[");
        this.isQuit = false;
        this.index = 0;
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

    public boolean getIsQuit() {
        return isQuit;
    }

    public int getIndex() {
        return index;
    }

}
