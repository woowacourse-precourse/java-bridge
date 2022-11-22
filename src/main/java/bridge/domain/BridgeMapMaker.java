package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeMapMaker {
    final private List<String> userPath;
    private List<String> bridge;

    public BridgeMapMaker(List<String> userPath, List<String> bridge) {
        this.userPath = userPath;
        this.bridge = bridge;
    }

    public List<List<String>> makeMap() {
        List<List<String>> map = new ArrayList<>();
        map.add(makeUpperMap());
        map.add(makeLowerMap());
        return map;
    }

    private List<String> makeUpperMap() {
        List<String> upperPathMap = new ArrayList<>();
        for (int i = 0; i < userPath.size(); i++) {
            upperPathMap.add(makeUpperMoveResult(bridge.get(i), userPath.get(i)));
        }
        return upperPathMap;
    }

    private List<String> makeLowerMap() {
        List<String> lowerPathMap = new ArrayList<>();
        for (int i = 0; i < userPath.size(); i++) {
            lowerPathMap.add(makeLowerMoveResult(bridge.get(i), userPath.get(i)));
        }
        return lowerPathMap;
    }

    private String makeUpperMoveResult(String bridgePath, String userPath) {
        if (!bridgePath.equals(userPath) && bridgePath.equals("D")) {
            return "X";
        }
        if (bridgePath.equals("U") && userPath.equals("U")) {
            return "O";
        }
        return " ";
    }

    private String makeLowerMoveResult(String bridgePath, String userPath) {
        if (!bridgePath.equals(userPath) && bridgePath.equals("U")) {
            return "X";
        }
        if (bridgePath.equals("D") && userPath.equals("D")) {
            return "O";
        }
        return " ";
    }
}
