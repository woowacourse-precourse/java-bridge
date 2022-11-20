package model;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {
    private static final String BRIDGE_START = "[ ";
    private static final String BRIDGE_CONNECT = " | ";
    private static final String BRIDGE_END = " ]";
    private final List<String> map;

    public BridgeMap() {
        map = new ArrayList<>();
    }

    public void updateMap(Boolean result) {
        map.add(ResultType.getMarkByBoolean(result));
    }

    public String getPrintMap() {
        StringBuilder builder = new StringBuilder();
        builder.append(BRIDGE_START);
        builder.append(String.join(BRIDGE_CONNECT, map));
        builder.append(BRIDGE_END);
        return builder.toString();
    }

    public void reset() {
        map.clear();
    }
}
