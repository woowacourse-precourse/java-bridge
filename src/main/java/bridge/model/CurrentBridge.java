package bridge.model;

import java.util.*;

public class CurrentBridge {
    private static final String MAP_START = "[ ";
    private static final String MAP_SEPARATOR = " | ";
    private static final String MAP_END = " ]";

    private static final String SUCCESS = "성공";
    private static final String FAILS = "실패";

    private static List<List<String>> currentMap;
    private static int numberOfAttempts;
    private static String outcome;

    public CurrentBridge() {
        this.currentMap = new ArrayList<>();
        this.numberOfAttempts = 1;
        this.outcome = "";
    }

    protected String saveMap(String mapPosition) {
        this.currentMap.add(Arrays.asList(mapPosition.split("-")));

        return drawCurrentMap();
    }

    protected String drawCurrentMap() {
        StringJoiner upStairMap = new StringJoiner(MAP_SEPARATOR, MAP_START, MAP_END);
        StringJoiner downStairMap = new StringJoiner(MAP_SEPARATOR, MAP_START, MAP_END);
        for (List<String> location : currentMap) {
            upStairMap.add(location.get(1));
            downStairMap.add(location.get(0));
        }
        String map = upStairMap.toString() + "\n" + downStairMap.toString();
        return map;
    }

    protected void clearMap() {
        this.numberOfAttempts++;
        this.outcome = FAILS;
        this.currentMap.clear();
    }

    public static int getSize() {
        return currentMap.size();
    }

//    protected boolean isCross() {
//        return !currentMap.get(-1).contains("X");
//    }

}
