package bridge.domain;

import bridge.constant.Bridge;

public class Map {

    private String upMap;
    private String downMap;

    public Map() {
        this.upMap = Bridge.OPEN.getState();
        this.downMap = Bridge.OPEN.getState();
    }

    public void makeUpMap(String result) {
        upMap += result + Bridge.MIDDLE.getState();
        downMap += Bridge.BLANK.getState() + Bridge.MIDDLE.getState();
    }

    public void makeDownMap(String result) {
        upMap += Bridge.BLANK.getState() + Bridge.MIDDLE.getState();
        downMap += result + Bridge.MIDDLE.getState();
    }

    public void resetMap() {
        upMap = Bridge.OPEN.getState();
        downMap = Bridge.OPEN.getState();
    }

    public String getUpMap() {
        return upMap.substring(0, upMap.length() - 1) + Bridge.CLOSE.getState();
    }

    public String getDownMap() {
        return downMap.substring(0, downMap.length() - 1) + Bridge.CLOSE.getState();
    }
}
