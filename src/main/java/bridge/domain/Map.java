package bridge.domain;

import bridge.constant.Bridge;

public class Map {
    private static final String OPEN_SYMBOL = "[";
    private static final String MIDDLE_SYMBOL = "|";
    private static final String CLOSE_SYMBOL = "]";

    private String upMap;
    private String downMap;

    public Map() {
        this.upMap = OPEN_SYMBOL;
        this.downMap = OPEN_SYMBOL;
    }

    public void makeUpMap(String result) {
        upMap += result + MIDDLE_SYMBOL;
        downMap += Bridge.BLANK.getLocation() + MIDDLE_SYMBOL;
    }

    public void makeDownMap(String result) {
        upMap += Bridge.BLANK.getLocation() + MIDDLE_SYMBOL;
        downMap += result + MIDDLE_SYMBOL;
    }

    public void resetMap() {
        upMap = OPEN_SYMBOL;
        downMap = OPEN_SYMBOL;
    }

    public String getUpMap() {
        return upMap.substring(0, upMap.length() - 1) + CLOSE_SYMBOL;
    }

    public String getDownMap() {
        return downMap.substring(0, downMap.length() - 1) + CLOSE_SYMBOL;
    }
}
