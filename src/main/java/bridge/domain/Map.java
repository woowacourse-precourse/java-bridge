package bridge.domain;

import bridge.constant.BridgeSymbol;

public class Map {

    private StringBuilder upMap;
    private StringBuilder downMap;

    public Map() {
        this.upMap = new StringBuilder(BridgeSymbol.OPEN.getState());
        this.downMap = new StringBuilder(BridgeSymbol.OPEN.getState());
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
        upMap = new StringBuilder(BridgeSymbol.OPEN.getState());
        downMap = new StringBuilder(BridgeSymbol.OPEN.getState());
    }

    public String getUpMap() {
        return upMap.substring(0, upMap.length() - 1) + BridgeSymbol.CLOSE.getState();
    }

    public String getDownMap() {
        return downMap.substring(0, downMap.length() - 1) + BridgeSymbol.CLOSE.getState();
    }
}
