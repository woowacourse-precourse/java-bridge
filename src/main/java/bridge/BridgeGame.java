package bridge;

import bridge.enums.ControlKey;

public class BridgeGame {

    private Bridge bridge;
    private MapMaker mapMaker;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.mapMaker = new MapMaker();
    }

    public boolean move(String inputKey, int index) {
        return bridge.canCross(inputKey, index);
    }

    public boolean retry(String inputKey) {
        return inputKey.equals(ControlKey.RETRY.getKey());
    }

    public String getMap(int index, String move) {
        return mapMaker.makeMap(bridge, index, move);
    }

    public String getResultMap() {
        return mapMaker.makeResultMap();
    }

    public void initMap() {
        mapMaker.initBridge();
    }
}
