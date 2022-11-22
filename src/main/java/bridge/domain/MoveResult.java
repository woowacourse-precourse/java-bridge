package bridge.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MoveResult {

    private static final String CAN_MOVE_MARK = "O";
    private static final String CAN_NOT_MOVE_MARK = "X";
    private static final String EMPTY_MARK = " ";

    private boolean isSuccess;
    private int tryCount;

    private final Map<BridgeCellType, List<String>> moveHistory = new LinkedHashMap<>() {{
        List.of(BridgeCellType.values())
            .forEach(cellType -> put(cellType, new ArrayList<>()));
    }};

    public MoveResult() {
        this.isSuccess = false;
        this.tryCount = 1;
    }

    public void success(BridgeCellType cellType) {
        this.isSuccess = true;
        moveHistory.get(cellType).add(CAN_MOVE_MARK);
        setOtherCellEmpty(cellType);
    }

    public void fail(BridgeCellType cellType) {
        this.isSuccess = false;
        moveHistory.get(cellType).add(CAN_NOT_MOVE_MARK);
        setOtherCellEmpty(cellType);
    }

    private void setOtherCellEmpty(BridgeCellType cellType) {
        moveHistory.keySet().stream()
            .filter(key -> !cellType.equals(key))
            .forEach(key -> moveHistory.get(key).add(EMPTY_MARK));
    }

    public void clearMoveHistory() {
        this.moveHistory.forEach((key, value) -> value.clear());
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void increaseTryCount() {
        this.tryCount++;
    }

    public Map<BridgeCellType, List<String>> getMoveHistory() {
        return new HashMap<>(moveHistory);
    }

    @Override
    public String toString() {
        return moveHistory.values().stream()
            .map(value -> "[ " + String.join(" | ", value) + " ]")
            .collect(Collectors.joining("\n"));
    }
}
