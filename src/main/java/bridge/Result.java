package bridge;

import bridge.bridge.BridgeMaker;

import java.util.List;

public class Result {
    private static final String START_BRIDGE_CHARACTER = "[";
    private static final String SUCCESS = " O ";
    private static final String FAIL = " X ";
    private static final String SEPARATOR = "|";
    private static final String BLANK = "   ";
    private static final String END_BRIDGE_CHARACTER = "]";
    private String topBridgeResult;
    private String bottomBridgeResult;
    
    public Result() {
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

    public boolean findFail(List<String> bridge, List<String> moves) {
        for (int findIndex = 0; findIndex < moves.size(); findIndex++) {
            if (!bridge.get(findIndex).equals(moves.get(findIndex))) {
                return true;
            }
            compareMoveCommand(moves.get(findIndex));
        }
        return false;
    }
}
