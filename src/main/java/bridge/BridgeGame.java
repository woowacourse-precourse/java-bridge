package bridge;

import bridge.utils.Value;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private List<String> bridge;
    private List<String> movementRecord;
    private int count;

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
        movementRecord = new ArrayList<>();
        count = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction) {
        movementRecord.add(direction);
    }

    public String[][] getCurrentMap() {
        String[][] record = new String[2][movementRecord.size()];
        for (int i = 0; i < movementRecord.size(); i++) {
            if (movementRecord.get(i).equals(Value.UP)) {
                record[0][i] = isMovable(isMovable(i, movementRecord.get(i)));
                record[1][i] = " ";
            }
            if (movementRecord.get(i).equals(Value.DOWN)) {
                record[0][i] = " ";
                record[1][i] = isMovable(isMovable(i, movementRecord.get(i)));
            }
        }
        return record;
    }

    public boolean isGameOver() {
        if (!bridge.get(movementRecord.size()-1).equals(movementRecord.get(movementRecord.size()-1))) {
            return true;
        }
        if (movementRecord.size() == bridge.size()) {
            return true;
        }
        return false;
    }

    private boolean isMovable(int index, String direction) {
        if (index < bridge.size() && bridge.get(index).equals(direction)) {
            return true;
        }
        return false;
    }

    private String isMovable(boolean movable) {
        if (movable) {
            return Value.POSSIBLE;
        }
        return Value.IMPOSSIBLE;
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        movementRecord.clear();
        count++;
    }
}
