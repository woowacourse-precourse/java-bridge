package bridge.domain;

import java.util.List;
import java.util.Stack;

public class BridgeMap {
    private final Stack<String> upperRow = new Stack<>();
    private final Stack<String> lowerRow = new Stack<>();

    public void update(Moving moving, BridgeGameState state) {
        state.marking(this, moving);
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
