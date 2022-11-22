package model;

import java.util.List;


public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public String getAnswer(int currentLocation) {
        return bridge.get(currentLocation - 1);
    }

}
