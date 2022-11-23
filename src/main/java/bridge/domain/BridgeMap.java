package bridge.domain;

import bridge.domain.util.Position;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

public class BridgeMap {
    private LinkedHashMap<String, List<String>> bridgeMap = new LinkedHashMap<>() {{
        put(Position.UP.getInitial(), new ArrayList<>());
        put(Position.DOWN.getInitial(), new ArrayList<>());
    }};
    private final String SUCESS_CELL = "O";
    private final String FAILED_CELL = "X";
    private final String BLANK_CELL = " ";

    public void createMap(boolean isMove, String moving) {
        String cell = FAILED_CELL;
        if (isMove) {
            cell = SUCESS_CELL;
        }
        addMap(cell, moving);
    }

    private void addMap(String cell, String moving) {
        if (Objects.equals(moving, Position.UP.getInitial())) {
            bridgeMap.get(Position.UP.getInitial()).add(cell);
            bridgeMap.get(Position.DOWN.getInitial()).add(BLANK_CELL);
            return;
        }
        bridgeMap.get(Position.UP.getInitial()).add(BLANK_CELL);
        bridgeMap.get(Position.DOWN.getInitial()).add(cell);
    }

    public LinkedHashMap<String, List<String>> getMap() {
        return this.bridgeMap;
    }

    public void initialization() {
        bridgeMap = new LinkedHashMap<>() {{
            put(Position.UP.getInitial(), new ArrayList<>());
            put(Position.DOWN.getInitial(), new ArrayList<>());
        }};
    }
}
