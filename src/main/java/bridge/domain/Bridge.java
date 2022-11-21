package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private List<String> Bridge = new ArrayList<>();

    public Bridge(List<String> bridge) {
        Bridge = bridge;
    }

    public List<String> getBridge() {
        return Bridge;
    }

    public void setBridge(List<String> bridge) {
        Bridge = bridge;
    }
}
