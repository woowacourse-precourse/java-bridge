package bridge;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private final List<String> state = new ArrayList<>();
    private int count;
    private boolean movable;

    public Result() {
        this.count = 0;
        this.movable = true;
    }


    public int nowCount() {
        return count;
    }

    public boolean movable() {
        return movable;
    }

    public void updateState(String inputMove, boolean movable) {
        this.state.add(inputMove);
        this.movable = movable;
        this.count++;
    }
}
