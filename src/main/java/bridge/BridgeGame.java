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
    private BridgeController bridgeController;

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
                moveUpSuccess();
            }
            if (bridge.get(tryCount).equals("D")) {
                moveUpFailed();
            }
        }
    }

    public void moveDown(List<String> bridge, int tryCount, String sideToMove) {
        if (sideToMove.equals("D")) {
            if (bridge.get(tryCount).equals("D")) {
                moveDownSuccess();
            }
            if (bridge.get(tryCount).equals("U")) {
                moveDownFailed();
            }
        }
    }

    public void moveDownSuccess() {
        int lastIndex = initialUpBridge.lastIndexOf("]");
        initialDownBridge.insert(lastIndex, MOVABLE);
        initialUpBridge.insert(lastIndex, SPACE);
    }

    public void moveUpSuccess() {
        int lastIndex = initialUpBridge.lastIndexOf("]");
        initialUpBridge.insert(lastIndex, MOVABLE);
        initialDownBridge.insert(lastIndex, SPACE);
    }

    public void moveDownFailed() {
        int lastIndex = initialUpBridge.lastIndexOf("]");
        initialDownBridge.insert(lastIndex, UNMOVABLE);
        initialUpBridge.insert(lastIndex, SPACE);
    }

    public void moveUpFailed() {
        int lastIndex = initialUpBridge.lastIndexOf("]");
        initialUpBridge.insert(lastIndex, UNMOVABLE);
        initialDownBridge.insert(lastIndex, SPACE);
    }

    public void createSeparator(int tryCount) {
        if (tryCount > 0) {
            int lastIndex = initialUpBridge.lastIndexOf("]");
            initialUpBridge.insert(lastIndex, SPLIT_BY);
            initialDownBridge.insert(lastIndex, SPLIT_BY);
        }
    }

    public void retry(String retryCommand, List<String> moveResult, int gameCount) {
        bridgeController = new BridgeController();
        if (retryCommand.equals("R")) {
            bridgeController.moveController();
        }
        if (retryCommand.equals("Q")) {
            bridgeController.resultController(moveResult, gameCount);
        }
    }

    public boolean isFailed(List<String> moveResult) {
        int lastIndex = moveResult.size() - 1;
        if (moveResult.get(lastIndex).contains(UNMOVABLE) ||
                moveResult.get(lastIndex - 1).contains(UNMOVABLE)) { // 게임실패
            return true;
        }
        return false;
    }
}