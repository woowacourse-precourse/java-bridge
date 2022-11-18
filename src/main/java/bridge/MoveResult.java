package bridge;

import java.util.ArrayList;
import java.util.List;

public class MoveResult {
    private List<String> highBridge = new ArrayList<>();
    private List<String> lowBridge = new ArrayList<>();

    public void makeResultBridge(String moving, boolean movingPossible) {
        if (moving.equals("U")) {
            up(movingPossible);
        }
        if (moving.equals("D")) {
            down(movingPossible);
        }
    }

    public void clearHistory() {
        lowBridge.clear();
        highBridge.clear();
    }

    public void printBridge(OutputView outputView) {
        outputView.printMap(lowBridge, highBridge);
    }

    private void up(boolean success) {
        if (success) {
            highBridge.add("O");
            lowBridge.add(" ");
        }
        if (!success) {
            highBridge.add("X");
            lowBridge.add(" ");
        }
    }

    private void down(boolean success) {
        if (success) {
            highBridge.add(" ");
            lowBridge.add("O");
        }
        if (!success) {
            highBridge.add(" ");
            lowBridge.add("X");
        }
    }
}
