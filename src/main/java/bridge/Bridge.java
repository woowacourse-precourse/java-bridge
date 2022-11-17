package bridge;

import java.util.List;

public class Bridge {
    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    private final List<String> bridge;

    public boolean move(String controlWord, int round) {
        return bridge.get(round).matches(controlWord);
    }
}
