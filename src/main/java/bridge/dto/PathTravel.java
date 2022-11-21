package bridge.dto;

import java.util.List;

public class PathTravel {
    private final List<String> upperBridge;
    private final List<String> lowerBridge;

    public PathTravel(List<String> upperBridge, List<String> lowerBridge) {
        this.upperBridge = upperBridge;
        this.lowerBridge = lowerBridge;
    }

    public List<String> getUpperBridge() {
        return upperBridge;
    }

    public List<String> getLowerBridge() {
        return lowerBridge;
    }
}