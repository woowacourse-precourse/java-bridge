package bridge.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

public class BridgeMap {
    private final LinkedHashMap<String, List<String>> bridgeMap = new LinkedHashMap<>() {{
        put(Constant.MOVED_POSITION_UP, new ArrayList<>());
        put(Constant.MOVED_POSITION_DOWN, new ArrayList<>());
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
        if (Objects.equals(moving, Constant.MOVED_POSITION_UP)) {
            bridgeMap.get(Constant.MOVED_POSITION_UP).add(cell);
            bridgeMap.get(Constant.MOVED_POSITION_DOWN).add(BLANK_CELL);
            return;
        }
        bridgeMap.get(Constant.MOVED_POSITION_UP).add(BLANK_CELL);
        bridgeMap.get(Constant.MOVED_POSITION_DOWN).add(cell);
    }

    public LinkedHashMap<String, List<String>> getMap(){
        return this.bridgeMap;
    }
}
