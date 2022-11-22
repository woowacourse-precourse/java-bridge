package bridge.bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<String> state;

    public Bridge() {
        this.state = new ArrayList<>();
    }

    public Bridge(List<String> state) {
        this.state = state;
    }

    public int size() {
        return state.size();
    }

    public String get(int index) {
        return state.get(index);
    }

    public void add(String s) {
        state.add(s);
    }

    public void clear() {
        state.clear();
    }
}
