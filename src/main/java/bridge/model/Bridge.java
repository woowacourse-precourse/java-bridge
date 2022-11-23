package bridge.model;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean checkStep(int index, String step) {
        return bridge.get(index).equals(step);
    }

    public boolean isEnd(int index) {
        return bridge.size() == index + 1;
    }
}
