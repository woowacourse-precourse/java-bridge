package bridge;

import bridge.constant.State;
import java.util.List;

public class UserInfo {
    private final List<String> input;
    private final int time;
    private final State state;

    public UserInfo(List<String> input, int time, State state) {
        this.input = input;
        this.time = time;
        this.state = state;
    }

    public List<String> getInput() {
        return input;
    }

    public int getTime() {
        return time;
    }

    public State getState() {
        return state;
    }
}
