package bridge.domain;

import bridge.util.Position;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

public class BridgeMap {
    private LinkedHashMap<String, List<String>> bridgeMap = new LinkedHashMap<>() {{
        put(Position.UP.getInitial(), new ArrayList<>());
        put(Position.DOWN.getInitial(), new ArrayList<>());
    }};
    private final String SUCESS = "O";
    private final String FAILED = "X";
    private final String BLANK = " ";

    public LinkedHashMap<String, List<String>> getMap() {
        return this.bridgeMap;
    }

    public void initial() {
        bridgeMap = new LinkedHashMap<>() {{
            put(Position.UP.getInitial(), new ArrayList<>());
            put(Position.DOWN.getInitial(), new ArrayList<>());
        }};
    }
    public void createMap(boolean isMove, String moving) {
        String str = FAILED;
        if (isMove) {
            str = SUCESS;
        }
        addMap(str, moving);
    }

    private void addMap(String cell, String moving) {
        if (Objects.equals(moving, Position.UP.getInitial())) {
            bridgeMap.get(Position.UP.getInitial()).add(cell);
            bridgeMap.get(Position.DOWN.getInitial()).add(BLANK);
            return;
        }
        bridgeMap.get(Position.UP.getInitial()).add(BLANK);
        bridgeMap.get(Position.DOWN.getInitial()).add(cell);
    }
}