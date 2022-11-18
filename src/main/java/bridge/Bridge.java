package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private List<String> availableBridge;
    private List<String> upperBridge;
    private List<String> lowerBridge;

    public Bridge(List<String> availableBridge, int size) {
        this.availableBridge = availableBridge;
        this.upperBridge = new ArrayList<>(size);
        this.lowerBridge = new ArrayList<>(size);
    }
}
