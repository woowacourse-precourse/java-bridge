package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean compareWithPosition(int position, String str) {
        return bridge.get(position).equals(str);
    }
}
