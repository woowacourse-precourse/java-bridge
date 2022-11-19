package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private final String MOVABLE = "O ";
    private final String UNMOVABLE = "X ";
    private final String SPLIT_BY = "| ";
    private final String SPACE = "  ";
    private StringBuilder initialUpBridge = new StringBuilder("[ ]");
    private StringBuilder initialDownBridge = new StringBuilder("[ ]");
    private List<String> moveResult = new ArrayList<>();

    public List<String> moveResult(List<String> bridge, int tryCount, String sideToMove) {
        move(bridge, tryCount, sideToMove);
        moveResult.add(initialUpBridge.toString());
        moveResult.add(initialDownBridge.toString());
        return moveResult;
    }

    public void move(List<String> bridge, int tryCount, String sideToMove) {
        createSeparator(tryCount);
        moveUp(bridge, tryCount, sideToMove);
        moveDown(bridge, tryCount, sideToMove);
    }

    public void moveUp(List<String> bridge, int tryCount, String sideToMove) {
        if (sideToMove.equals("U")) {
            if (bridge.get(tryCount).equals("U")) {
                moveSuccess();
            }
            if (bridge.get(tryCount).equals("D")) {
                moveFailed();
            }
        }
    }

    public void moveDown(List<String> bridge, int tryCount, String sideToMove) {
        if (sideToMove.equals("D")) {
            if (bridge.get(tryCount).equals("D")) {
                moveSuccess();
            }
            if (bridge.get(tryCount).equals("U")) {
                moveFailed();
            }
        }
    }

    public void moveSuccess() {
        int lastIndex = initialUpBridge.lastIndexOf("]");
        initialDownBridge.insert(lastIndex, MOVABLE);
        initialUpBridge.insert(lastIndex, SPACE);
    }

    public void moveFailed() {
        int lastIndex = initialUpBridge.lastIndexOf("]");
        initialDownBridge.insert(lastIndex, UNMOVABLE);
        initialUpBridge.insert(lastIndex, SPACE);
    }

    public void createSeparator(int tryCount) {
        if (tryCount > 0) {
            int lastIndex = initialUpBridge.lastIndexOf("]");
            initialUpBridge.insert(lastIndex, SPLIT_BY);
            initialDownBridge.insert(lastIndex, SPLIT_BY);
        }
    }

    public void retry(List<String> bridge, int tryCount) {
        new BridgeController().moveController(bridge, tryCount);
    }
}