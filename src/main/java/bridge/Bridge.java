package bridge;

import java.util.List;

public class Bridge {

    private final List<String> bridge;
    private int location;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public String next() {
        if (location >= bridge.size()) {
            throw new IllegalArgumentException();
        }
        return bridge.get(location++);
    }

    public void restart() {
        this.location = 0;
    }

}
