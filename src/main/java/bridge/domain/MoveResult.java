package bridge.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MoveResult {

    private static final String CAN_MOVE_MARK = "O";
    private static final String CAN_NOT_MOVE_MARK = "X";
    private static final String EMPTY_MARK = " ";

    private boolean isSuccess;
    private int tryCount;

    private final Map<BridgeCellType, List<String>> moveResults = new HashMap<>() {{
        List.of(BridgeCellType.values())
            .forEach(cellType -> put(cellType, new ArrayList<>()));
    }};

    public void success(BridgeCellType cellType) {
        this.isSuccess = true;
        moveResults.get(cellType).add(CAN_MOVE_MARK);
        setOtherCellEmpty(cellType);
    }

    public void fail(BridgeCellType cellType) {
        this.isSuccess = false;
        moveResults.get(cellType).add(CAN_NOT_MOVE_MARK);
        setOtherCellEmpty(cellType);
    }

    private void setOtherCellEmpty(BridgeCellType cellType) {
        moveResults.keySet().stream()
            .filter(key -> !cellType.equals(key))
            .forEach(key -> moveResults.get(key).add(EMPTY_MARK));
    }

    public void clearMoveResults() {
        this.moveResults.forEach((key, value) -> value.clear());
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

    @Override
    public String toString() {
        return moveResults.values().stream()
            .map(value -> "[ " + String.join(" | ", value) + " ]")
            .collect(Collectors.joining("\n"));
    }
}
