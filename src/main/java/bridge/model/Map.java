package bridge.model;

import java.util.Collections;
import java.util.List;

public class Map {
    private static final String OPEN = "[";
    private static final String MIDDLE = " | ";
    private static final String CLOSE = "]";
    private static final String BLANK = " ";

    private StringBuilder upMap;
    private StringBuilder downMap;

    public Map() {
        this.upMap = new StringBuilder(OPEN + BLANK);
        this.downMap = new StringBuilder(OPEN + BLANK);
    }

    public void makeUpMap(String result) {
        upMap.append(result).append(MIDDLE);
        downMap.append(BLANK).append(MIDDLE);
    }

    public void makeDownMap(String result) {
        upMap.append(BLANK).append(MIDDLE);
        downMap.append(result).append(MIDDLE);
    }

    public void resetMap() {
        upMap = new StringBuilder(OPEN + BLANK);
        downMap = new StringBuilder(OPEN + BLANK);
    }

    private String getUpMap() {
        return upMap.substring(0, upMap.length() - 2) + CLOSE;
    }

    private String getDownMap() {
        return downMap.substring(0, downMap.length() - 2) + CLOSE;
    }

    public List<String> getAllMap() {
        return Collections.unmodifiableList(List.of(getUpMap(), getDownMap()));
    }
}
