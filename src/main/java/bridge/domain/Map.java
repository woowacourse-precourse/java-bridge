package bridge.domain;

import bridge.constant.Bridge;

public class Map {
    private String upMap;
    private String downMap;

    public Map() {
        this.upMap = "[";
        this.downMap = "[";
    }

    public void makeUpMap(String result) {
        upMap += result + "|";
        downMap += Bridge.BLANK.getLocation() + "|";
    }

    public void makeDownMap(String result) {
        upMap += Bridge.BLANK.getLocation() + "|";
        downMap += result + "|";
    }

    public void resetMap() {
        upMap = "[";
        downMap = "[";
    }

    public String getUpMap() {
        return upMap.substring(0, upMap.length() - 1) + "]";
    }

    public String getDownMap() {
        return downMap.substring(0, downMap.length() - 1) + "]";
    }
}
