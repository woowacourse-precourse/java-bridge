package bridge;

import java.util.ArrayList;
import java.util.List;

public class MapMaker {
    private final String MOVE_SUCCESS = " O ";
    private final String MOVE_FAIL = " X ";
    private final String MOVE_EMPTY = "   ";
    private final String MAP_CONN = "|";
    private final String MAP_START = "[";
    private final String MAP_END = "]";
    private final String MAP_NEW_LINE = "\n";
    private List<String> upBridgeMap;
    private List<String> downBridgeMap;

    public MapMaker() {
        upBridgeMap = new ArrayList<>();
        downBridgeMap = new ArrayList<>();
    }

    public void makeSuccessMap(String moving) {
        if (moving.equals(Position.UP.getValue())) {
            upBridgeMap.add(MOVE_SUCCESS);
            downBridgeMap.add(MOVE_EMPTY);
            return ;
        }
        upBridgeMap.add(MOVE_EMPTY);
        downBridgeMap.add(MOVE_SUCCESS);
    }

    public void makeFailMap(String moving) {
        if (moving.equals(Position.UP.getValue())) {
            upBridgeMap.add(MOVE_FAIL);
            downBridgeMap.add(MOVE_EMPTY);
            return ;
        }
        upBridgeMap.add(MOVE_EMPTY);
        downBridgeMap.add(MOVE_FAIL);
    }

    public void initMap() {
        upBridgeMap = new ArrayList<>();
        downBridgeMap = new ArrayList<>();
    }

    private String makeMapView(List<String> bridgeStatus) {
        return MAP_START + String.join(MAP_CONN, bridgeStatus) + MAP_END;
    }

    public String getCurrentMap() {
        return makeMapView(upBridgeMap) + MAP_NEW_LINE + makeMapView(downBridgeMap);
    }

}
