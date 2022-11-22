package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private final List<String> input = new ArrayList<>();
    private final List<Boolean> movable = new ArrayList<>();

    public Result() {
        this.movable.add(true);
    }

    public boolean movable() {
        return movable.get(movable.size() - 1);
    }

    public void updateState(String inputMove, boolean movable) {
        input.add(inputMove);
        this.movable.add(movable);
    }

    public int stateSize() {
        return input.size();
    }

    public boolean getState(int index) {
        return movable.get(index);
    }

    public String getInput(int index) {
        return this.input.get(index);
    }
}
