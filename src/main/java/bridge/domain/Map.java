package bridge.domain;

import bridge.constant.BridgeSymbol;

import java.util.Collections;
import java.util.List;

public class Map {
    private static final String SPACE = " ";
    private StringBuilder upMap;
    private StringBuilder downMap;

    public Map() {
        this.upMap = new StringBuilder(BridgeSymbol.OPEN.getState() + SPACE);
        this.downMap = new StringBuilder(BridgeSymbol.OPEN.getState() + SPACE);
    }

    public void makeUpMap(String result) {
        upMap.append(result).append(BridgeSymbol.MIDDLE.getState());
        downMap.append(BridgeSymbol.BLANK.getState()).append(BridgeSymbol.MIDDLE.getState());
    }

    public void makeDownMap(String result) {
        upMap.append(BridgeSymbol.BLANK.getState()).append(BridgeSymbol.MIDDLE.getState());
        downMap.append(result).append(BridgeSymbol.MIDDLE.getState());
    }

    public void resetMap() {
        upMap = new StringBuilder(BridgeSymbol.OPEN.getState() + SPACE);
        downMap = new StringBuilder(BridgeSymbol.OPEN.getState() + SPACE);
    }

    private String getUpMap() {
        return upMap.substring(0, upMap.length() - 2) + BridgeSymbol.CLOSE.getState();
    }

    private String getDownMap() {
        return downMap.substring(0, downMap.length() - 2) + BridgeSymbol.CLOSE.getState();
    }

    public List<String> getAllMap() {
        return Collections.unmodifiableList(List.of(getUpMap(), getDownMap()));
    }
}
