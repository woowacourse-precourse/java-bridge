package bridge.domain;

import bridge.utils.Value;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeGame {
    private List<String> bridge;
    private List<Direction> movementRecord;
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
        movementRecord.add(Direction.getDirection(direction));
    }

    public String[][] getCurrentMap() {
        String[][] map = getEmptyMap();
        for (int i = 0; i < movementRecord.size(); i++) {
            Direction dir = movementRecord.get(i);
            map[dir.getIndex()][i] = marking(isMovable(i, dir.getCommand()));
        }
        return map;
    }

    public boolean isFailed() {
        String direction = movementRecord.get(movementRecord.size() - 1).getCommand();
        if (!bridge.get(movementRecord.size() - 1).equals(direction)) {
            return true;
        }
        return false;
    }

    public boolean isSuccessful() {
        if (!isFailed() && movementRecord.size() == bridge.size()) {
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

    private String marking(boolean movable) {
        if (movable) {
            return Value.POSSIBLE;
        }
        return Value.IMPOSSIBLE;
    }

    private void initMap(String[][] map) {
        for (String[] line : map) {
            Arrays.fill(line, " ");
        }
    }

    private String[][] getEmptyMap() {
        String[][] emptyMap = new String[2][movementRecord.size()];
        initMap(emptyMap);
        return emptyMap;
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

    public int getAttempts() {
        return count;
    }
}
