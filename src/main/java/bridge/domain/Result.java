package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private final List<String> state = new ArrayList<>();
    private final List<String> input = new ArrayList<>();
    private boolean movable;

    public Result() {
        this.movable = true;
    }

    public boolean movable() {
        return movable;
    }

    public void updateState(String inputMove, boolean movable) {
        addMove(movable);
        input.add(inputMove);
        this.movable = movable;
    }

    private void addMove(boolean movable) {
        if (movable) {
            this.state.add("O");
            return;
        }
        this.state.add("X");
    }

    public List<String> getState() {
        return state;
    }

    public String getState(int index) {
        return this.state.get(index);
    }

    public String getInput(int index) {
        return this.input.get(index);
    }
}
