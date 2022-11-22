package bridge.domain;

import bridge.BridgeMaker;
import bridge.util.MoveResult;
import java.util.ArrayList;
import java.util.List;

public class Bridge {
    final private List<String> userPath;
    private List<String> bridge;
    private int tryCount;

    public Bridge() {
        userPath = new ArrayList<>();
        tryCount = 1;
    }

    public void makeBridge(int bridgeSize, BridgeMaker bridgeMaker) {
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    public MoveResult move(String movePath) {
        userPath.add(movePath);

        if (isLastMoveSuccess() && isGameSuccess()) {
            return MoveResult.PASSED_BRIDGE;
        }
        if (isLastMoveSuccess()) {
            return MoveResult.MOVE_SUCCESS;
        }
        return MoveResult.MOVE_FAIL;
    }

    public void initBridge() {
        userPath.clear();
        tryCount++;
    }

    public List<List<String>> getMap() {
        List<List<String>> map = new ArrayList<>();
        map.add(makeUpperMap());
        map.add(makeLowerMap());
        return map;
    }

    public boolean isGameSuccess() {
        return bridge.size() == userPath.size();
    }

    public int getTryCount() {
        return tryCount;
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

    private boolean isLastMoveSuccess() {
        int lastIndex = userPath.size() - 1;
        return bridge.get(lastIndex).equals(userPath.get(lastIndex));
    }
}
