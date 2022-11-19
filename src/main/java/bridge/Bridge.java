package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<String> bridge;
    private int state;

    public Bridge(List<String> bridge) {
        this.bridge = new ArrayList<>();
        this.state = 0;
    }

    public List<String> getbridge() {
        return bridge;
    }

    public int getState() {
        return state;
    }
}
