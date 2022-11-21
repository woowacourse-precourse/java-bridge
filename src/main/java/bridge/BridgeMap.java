package bridge;

import java.util.List;
import java.util.Stack;

public class BridgeMap {
    public static final String UP = "U";
    public static final String DOWN = "D";
    public static final String SPACE = " ";
    public static final String SUCCESS = "O";
    public static final String FAIL = "X";
    private final Stack<String> upperRow = new Stack<>();
    private final Stack<String> lowerRow = new Stack<>();

    public void update(String selectedDirection, BridgeGameState state) {
        if (state == BridgeGameState.NORMAL) {
            markSuccess(selectedDirection);
        }
        if (state == BridgeGameState.GAME_OVER) {
            markFail(selectedDirection);
        }
    }

    private void markSuccess(String selectedDirection) {
        if (selectedDirection.equals(UP)) {
            upperRow.add(SUCCESS);
            lowerRow.add(SPACE);
        }
        if (selectedDirection.equals(DOWN)) {
            upperRow.add(SPACE);
            lowerRow.add(SUCCESS);
        }
    }

    private void markFail(String selectedDirection) {
        if (selectedDirection.equals(UP)) {
            upperRow.add(FAIL);
            lowerRow.add(SPACE);
        }
        if (selectedDirection.equals(DOWN)) {
            upperRow.add(SPACE);
            lowerRow.add(FAIL);
        }
    }

    public void reset() {
        upperRow.clear();
        lowerRow.clear();
    }

    public List<String> getUpperRow() {
        return List.copyOf(upperRow);
    }

    public List<String> getLowerRow() {
        return List.copyOf(lowerRow);
    }
}
