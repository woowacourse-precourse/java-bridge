package model;

import java.util.List;

import static controller.Util.validateSize;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        validateSize(bridge.size());
        this.bridge = bridge;
    }

    public String getAnswer(int currentLocation) {
        return bridge.get(currentLocation);
    }

}
