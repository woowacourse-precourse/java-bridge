package bridge;

import java.util.ArrayList;
import java.util.List;

public class MoveResult {
    private static final String MOVE_TO_UP = "U";
    private static final String MOVE_TO_DOWN = "D";
    private static final String SPACE = " ";
    private static final String MOVE_POSSIBLE = "O";
    private static final String MOVE_IMPOSSIBLE = "X";
    private final List<String> highBridge = new ArrayList<>();
    private final List<String> lowBridge = new ArrayList<>();

    public void makeResultBridge(String moving, boolean movingPossible) {
        if (moving.equals(MOVE_TO_UP)) {
            up(movingPossible);
        }
        if (moving.equals(MOVE_TO_DOWN)) {
            down(movingPossible);
        }
    }

    public void clearHistory() {
        highBridge.clear();
        lowBridge.clear();
    }

    public void printBridge(OutputView outputView) {
        outputView.printMap(lowBridge, highBridge);
    }

    private void up(boolean success) {
        if (success) {
            highBridge.add(MOVE_POSSIBLE);
        }
        if (!success) {
            highBridge.add(MOVE_IMPOSSIBLE);
        }
        lowBridge.add(SPACE);
    }

    private void down(boolean success) {
        if (success) {
            lowBridge.add(MOVE_POSSIBLE);
        }
        if (!success) {
            lowBridge.add(MOVE_IMPOSSIBLE);
        }
        highBridge.add(SPACE);
    }
}
