package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private final List<String> upBridge;
    private final List<String> downBridge;

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
        DirectionType directionType = DirectionType.valueOfString(direction);
        MoveType[] moveResult = initializeMovingResult(validBridge, directionType);
        String downMove = moveResult[0].getValue();
        String upMove = moveResult[1].getValue();
        addBridge(downMove, upMove, index);
    }

    private void addBridge(String downMove, String upMove, int index) {
        downBridge.add(downMove);
        upBridge.add(upMove);
        if (index < bridge.size()-1) {
            downBridge.add("|");
            upBridge.add("|");
            return;
        }
        downBridge.add("]");
        upBridge.add("]");
    }

    private MoveType[] initializeMovingResult(String validBridge, DirectionType directionType) {
        int validNumber = Integer.parseInt(validBridge);

        MoveType[] moveResult = {MoveType.SPACE, MoveType.SPACE};
        moveResult[directionType.getNumber()] = MoveType.X;
        if (directionType.getNumber() == validNumber) {
            moveResult[directionType.getNumber()] = MoveType.O;
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
