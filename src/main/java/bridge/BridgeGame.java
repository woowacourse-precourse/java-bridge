package bridge;

import constants.GameCommand;
import constants.Symbol;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> upBridge = new ArrayList<>();
    private List<String> downBridge = new ArrayList<>();

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
    public boolean move(String bridge, String moving) {
        if (isCross(bridge, moving)) {
            moveIsCrossTrue(moving);
            return true;
        }
        moveIsCrossFalse(moving);
        return false;
    }

    public void moveIsCrossTrue(String moving) {
        if (moving.equals(GameCommand.UP.getGameCommand())) {
            upBridge.add(Symbol.CAN_MOVE.getSymbol());
            downBridge.add(Symbol.UN_CHOSEN.getSymbol());
        }
        if (moving.equals(GameCommand.DOWN.getGameCommand())) {
            upBridge.add(Symbol.UN_CHOSEN.getSymbol());
            downBridge.add(Symbol.CAN_MOVE.getSymbol());
        }
    }

    public void moveIsCrossFalse(String moving) {
        if (moving.equals(GameCommand.UP.getGameCommand())) {
            upBridge.add(Symbol.CANT_MOVE.getSymbol());
            downBridge.add(Symbol.UN_CHOSEN.getSymbol());
        }
        if (moving.equals(GameCommand.DOWN.getGameCommand())) {
            upBridge.add(Symbol.UN_CHOSEN.getSymbol());
            downBridge.add(Symbol.CANT_MOVE.getSymbol());
        }
    }

    public boolean isCross(String bridge, String moving) {
        if (bridge.equals(moving)) {
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        upBridge.clear();
        downBridge.clear();
    }
}
