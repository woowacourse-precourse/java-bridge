package bridge.domain;

import bridge.code.BridgePosition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameResult {

    private HashMap<Boolean, List<String>> resultMap;
    private int index;
    private int attempts;

    public GameResult() {
        this.attempts = 1;
        resetGameResult();
    }

    private HashMap<Boolean, List<String>> initMap() {
        HashMap<Boolean, List<String>> map = new HashMap<>();
        map.put(BridgePosition.UP, new ArrayList<>());
        map.put(BridgePosition.DOWN, new ArrayList<>());

        return map;
    }

    public void updateResultMap(String input, String result) {
        boolean isUp = input.equals("U");
        resultMap.get(isUp).add(result);
        resultMap.get(!isUp).add(" ");
        index++;
    }

    public void resetGameResult() {
        this.index = 0;
        this.resultMap = initMap();
    }

    public int updateGameResult() {
        resetGameResult();
        return ++this.attempts;
    }

    public int getAttempts() {
        return attempts;
    }

    public int getIndex() {
        return index;
    }

    public String upBridgeToString() {
        return "[ " + String.join(" | ", resultMap.get(BridgePosition.UP)) + " ]";
    }

    public String downBridgeToString() {
        return "[ " + String.join(" | ", resultMap.get(BridgePosition.DOWN)) + " ]";
    }

}
