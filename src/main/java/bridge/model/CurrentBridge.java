package bridge.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CurrentBridge {

    private static final String SUCCESS = "성공";
    private static final String FAILS = "실패";

    private List<List<String>> currentMap;
    private int numberOfAttempts;
    private String outcome;

    public CurrentBridge() {
        this.currentMap = new ArrayList<>();
        this.numberOfAttempts = 1;
        this.outcome = "";
    }

    protected List<List<String>> saveMap(String mapPosition) {
        this.currentMap.add(Arrays.asList(mapPosition.split("-")));
        return currentMap;
    }

    protected void clearMap() {
        this.numberOfAttempts++;
        this.outcome = FAILS;
        this.currentMap.clear();
    }
//    protected boolean isCross() {
//        return !currentMap.get(-1).contains("X");
//    }

}
