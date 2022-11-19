package model;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {
    private static final String LIST_CONNECT = ", ";
    private static final String BRIDGE_CONNECT = "|";
    final List<ResultType> map;

    public BridgeMap() {
        map = new ArrayList<>();
    }

    public void updateMap(Boolean result) {
        map.add(ResultType.getByBoolean(result));
    }

    public String getPrintMap() {
        return map.toString().replace(LIST_CONNECT, BRIDGE_CONNECT);
    }

    public void reset() {
        map.clear();
    }
}
