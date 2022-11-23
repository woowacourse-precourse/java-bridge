package bridge;

import bridge.bridge.BridgeMaker;

import java.util.List;

public class Result {
    private static final String START_BRIDGE_CHARACTER = "[ ";
    private static final String SUCCESS = "O";
    private static final String FAIL = "X";
    private static final String SEPARATOR = " | ";
    private static final String BLANK = " ";
    private static final String END_BRIDGE_CHARACTER = " ]";
    private String topBridgeResult;
    private String bottomBridgeResult;
    
    public Result() {
    }

    public void updateBridge(List<String> bridge, List<String> moves) {
        setBridgeMap();
        findFail(bridge, moves);
        topBridgeResult = topBridgeResult.substring(0, topBridgeResult.length() - 3);
        topBridgeResult += END_BRIDGE_CHARACTER;
        bottomBridgeResult = bottomBridgeResult.substring(0, bottomBridgeResult.length() - 3);
        bottomBridgeResult += END_BRIDGE_CHARACTER;
    }

    private void setBridgeMap() {
        topBridgeResult = START_BRIDGE_CHARACTER;
        bottomBridgeResult = START_BRIDGE_CHARACTER;
    }

    private void compareMoveCommand(String move) {
        if (move.equals(BridgeMaker.UP_BRIDGE_PHRASE)) {
            topBridgeResult += (SUCCESS + SEPARATOR);
            bottomBridgeResult += (BLANK + SEPARATOR);
        }
        if (move.equals(BridgeMaker.DOWN_BRIDGE_PHRASE)) {
            topBridgeResult += (BLANK + SEPARATOR);
            bottomBridgeResult += (SUCCESS + SEPARATOR);
        }
    }

    public void findFail(List<String> bridge, List<String> moves) {
        for (int findIndex = 0; findIndex < moves.size(); findIndex++) {
            if (!bridge.get(findIndex).equals(moves.get(findIndex))) {
                isFailedBridgeMap(moves.get(findIndex));
            }
            if (bridge.get(findIndex).equals(moves.get(findIndex))) {
                compareMoveCommand(moves.get(findIndex));
            }
        }
    }

    public String getTopBridgeResult() {
        return topBridgeResult;
    }

    public String getBottomBridgeResult() {
        return bottomBridgeResult;
    }

    private void isFailedBridgeMap(String bridge) {
        if (bridge.equals(BridgeMaker.UP_BRIDGE_PHRASE)) {
            topBridgeResult += (FAIL + SEPARATOR);
            bottomBridgeResult += (BLANK + SEPARATOR);
        }
        if (bridge.equals(BridgeMaker.DOWN_BRIDGE_PHRASE)) {
            topBridgeResult += (BLANK + SEPARATOR);
            bottomBridgeResult += (FAIL + SEPARATOR);
        }
    }
}
