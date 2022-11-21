package bridge;

import java.util.List;
import java.util.Stack;

public class BridgeMap {
    public static final String SUCCESS = "O";
    public static final String FAIL = "X";
    private final Stack<String> upperRow = new Stack<>();
    private final Stack<String> lowerRow = new Stack<>();

    public void update(Moving moving, BridgeGameState state) {
        if (state == BridgeGameState.NORMAL) {
            markSuccess(moving);
        }
        if (state == BridgeGameState.GAME_OVER) {
            markFail(moving);
        }
    }

    private void markSuccess(Moving moving) {
        moving.marking(this, SUCCESS);
    }

    private void markFail(Moving moving) {
        moving.marking(this, FAIL);
    }

    public void reset() {
        upperRow.clear();
        lowerRow.clear();
    }

    public void addUpperRow(String value) {
        upperRow.add(value);
    }

    public void addLowerRow(String value) {
        lowerRow.add(value);
    }

    public List<String> getUpperRow() {
        return List.copyOf(upperRow);
    }

    public List<String> getLowerRow() {
        return List.copyOf(lowerRow);
    }
}
