package model;

import type.MovingType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bridges {
    private final Bridge upperBridge;
    private final Bridge lowerBridge;

    public Bridges() {
        upperBridge = new Bridge(new ArrayList<>());
        lowerBridge = new Bridge(new ArrayList<>());
    }

    public void moveUpperBridge(String moving) {
        upperBridge.addBridge(moving);
        lowerBridge.addBridge(MovingType.BLANK.getResult());
    }

    public void moveLowerBridge(String moving) {
        upperBridge.addBridge(MovingType.BLANK.getResult());
        lowerBridge.addBridge(moving);
    }

    public int getSize() {
        return upperBridge.getSize();
    }

    public Map<String, Bridge> get() {
        Map<String, Bridge> bridges = new HashMap<>();
        bridges.put("upperBridge", upperBridge);
        bridges.put("lowerBridge", lowerBridge);
        return bridges;
    }
}
