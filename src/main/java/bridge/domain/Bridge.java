package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> roads;

    public Bridge(List<String> roads) {
        this.roads = roads;
    }

    public List<String> getRoads() {
        return roads;
    }
}
