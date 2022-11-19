package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return new ArrayList<>(bridge);
    }
}
