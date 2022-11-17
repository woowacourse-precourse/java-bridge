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

    private final Map<BridgeCellType, List<String>> moveResults = new HashMap<>() {{
        List.of(BridgeCellType.values())
            .forEach(cellType -> put(cellType, new ArrayList<>()));
    }};

    public void setResult(BridgeCellType cellType, boolean isMove) {
        String mark = getMark(isMove);
        moveResults.get(cellType).add(mark);
        moveResults.keySet().stream()
            .filter(key -> !cellType.equals(key))
            .forEach(key -> moveResults.get(key).add(EMPTY_MARK));
    }

    private static String getMark(boolean isMove) {
        if (isMove) {
            return CAN_MOVE_MARK;
        }
        return CAN_NOT_MOVE_MARK;
    }

    @Override
    public String toString() {
        return moveResults.values().stream()
            .map(value -> "[ " + String.join(" | ", value) + " ]")
            .collect(Collectors.joining("\n"));
    }
}
