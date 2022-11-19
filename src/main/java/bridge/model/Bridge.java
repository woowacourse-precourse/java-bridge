package bridge.model;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean compareSquare(String square, int index) {
        return bridge.get(index)
                .equals(square);
    }

}
