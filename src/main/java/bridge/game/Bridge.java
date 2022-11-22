package bridge.game;

import java.util.List;

public class Bridge {

    private final List<String> bridge;
    private final Integer distance;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
        this.distance = 0;
    }

    public Integer getDistance() {
        return distance;
    }

}
