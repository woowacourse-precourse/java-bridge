package model;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {
    private static final String LIST_CONNECT = ", ";
    private static final String BRIDGE_CONNECT = "|";
    final List<GameResult> map;

    public BridgeMap() {
        map = new ArrayList<>();
    }

    public void updateMap(Boolean result) {
        map.add(GameResult.getByBoolean(result));
    }

    public String getPrintMap() {
        return map.toString().replace(LIST_CONNECT, BRIDGE_CONNECT);
    }
}
