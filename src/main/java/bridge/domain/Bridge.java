package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<String> upperBridge;
    private final List<String> lowerBridge;

    public Bridge() {
        upperBridge = new ArrayList<>();
        lowerBridge = new ArrayList<>();
    }

    public void addupperBridge(String upperBridgeResult) {
        upperBridge.add(upperBridgeResult);
        lowerBridge.add(" ");
    }

    public void addLowerBridge(String lowerBridgeResult) {
        upperBridge.add(" ");
        lowerBridge.add(lowerBridgeResult);
    }

    @Override
    public String toString() {
        return upperBridge + "\n" + lowerBridge;
    }
}
