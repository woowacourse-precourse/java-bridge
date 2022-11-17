package bridge.model;

import java.util.*;

public class CurrentBridge {
    private static final String MAP_START = "[ ";
    private static final String MAP_SEPARATOR = " | ";
    private static final String MAP_END = " ]";

    private static final String SUCCESS = "성공";
    private static final String FAILS = "실패";

    private static List<List<String>> currentPosition;
    private static String currentMap;
    private static int numberOfAttempts;
    private static String outcome;

    protected CurrentBridge() {
        this.currentPosition = new ArrayList<>();
        this.numberOfAttempts = 1;
        this.outcome = "";
    }

    protected String saveMap(String mapPosition) {
        this.currentPosition.add(Arrays.asList(mapPosition.split("-")));
        drawCurrentMap();
        return this.currentMap;
    }

    private void drawCurrentMap() {
        StringJoiner upStairMap = new StringJoiner(MAP_SEPARATOR, MAP_START, MAP_END);
        StringJoiner downStairMap = new StringJoiner(MAP_SEPARATOR, MAP_START, MAP_END);
        for (List<String> location : currentPosition) {
            upStairMap.add(location.get(1));
            downStairMap.add(location.get(0));
        }
        this.currentMap = upStairMap.toString() + "\n" + downStairMap.toString();
    }

    protected void clearMap() {
        this.numberOfAttempts++;
        this.currentPosition.clear();
    }

    public static boolean canNotCross() {
        if (getSize() == 0) {
            return false;
        }
        if (currentPosition.get(getSize()-1).contains("X")) {
            outcome = FAILS;
            return true;
        }
        return false;
    }

    public static int getSize() {
        return currentPosition.size();
    }

    public static String getCurrentMap() {
        return currentMap;
    }
    public static int getNumberOfAttempts() {
        return numberOfAttempts;
    }
    public static String getOutcome() {
        return outcome;
    }
}
