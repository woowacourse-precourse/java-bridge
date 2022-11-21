package bridge.domain;

import bridge.constant.BridgeSymbol;

public class Map {

    private String upMap;
    private String downMap;

    public Map() {
        this.upMap = BridgeSymbol.OPEN.getState();
        this.downMap = BridgeSymbol.OPEN.getState();
    }

    public void makeUpMap(String result) {
        upMap += result + BridgeSymbol.MIDDLE.getState();
        downMap += BridgeSymbol.BLANK.getState() + BridgeSymbol.MIDDLE.getState();
    }

    public void makeDownMap(String result) {
        upMap += BridgeSymbol.BLANK.getState() + BridgeSymbol.MIDDLE.getState();
        downMap += result + BridgeSymbol.MIDDLE.getState();
    }

    public void resetMap() {
        upMap = BridgeSymbol.OPEN.getState();
        downMap = BridgeSymbol.OPEN.getState();
    }

    public String getUpMap() {
        return upMap.substring(0, upMap.length() - 1) + BridgeSymbol.CLOSE.getState();
    }

    public String getDownMap() {
        return downMap.substring(0, downMap.length() - 1) + BridgeSymbol.CLOSE.getState();
    }
}
