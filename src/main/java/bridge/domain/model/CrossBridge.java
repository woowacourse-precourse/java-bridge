package bridge.domain.model;

import java.util.ArrayList;
import java.util.List;

public class CrossBridge {

    private static List<Way> crossBridge = new ArrayList<>();
    private static int totalTry;
    private static boolean success;

    public CrossBridge() {
        CrossBridge.totalTry = 0;
        CrossBridge.success = false;
    }

    public void addCrossBridge(Way way) {
        CrossBridge.crossBridge.add(way);
    }

    public List<Way> getCrossBridge() {
        return crossBridge;
    }

    public int getCrossBridgeSize() {
        return getCrossBridge().size();
    }

    public void increaseTotalTry() {
        CrossBridge.totalTry++;
    }

    public int getTotalTry() {
        return totalTry;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(int bridgeSize) {
        if (bridgeSize == getCrossBridgeSize()) {
            CrossBridge.success = true;
        }
    }
}
