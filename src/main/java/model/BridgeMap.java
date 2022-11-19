package model;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {

    private static final String BRIDGE_START = "[ ";
    private static final String BRIDGE_CONNECT = " | ";
    private static final String BRIDGE_END = " ]";
    final List<ResultType> map;

    public BridgeMap() {
        map = new ArrayList<>();
    }

    public void updateMap(Boolean result) {
        map.add(ResultType.getByBoolean(result));
    }

    public String getPrintMap() {
        StringBuilder builder = new StringBuilder();

        builder.append(BRIDGE_START);
        for (ResultType result : map) {
            builder.append(result.getMark()).append(BRIDGE_CONNECT);
        }
        builder.setLength(builder.lastIndexOf(BRIDGE_CONNECT));
        builder.append(BRIDGE_END);

        return builder.toString();
    }

    public void reset() {
        map.clear();
    }
}
