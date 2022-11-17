package bridge;

import java.util.List;

public class Bridge {
    List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public void addBlock(String moving) {
        bridge.add(moving);
    }
}
