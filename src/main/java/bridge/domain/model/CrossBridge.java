package bridge.domain.model;

import java.util.ArrayList;
import java.util.List;

public class CrossBridge {

    private static final List<Way> crossBridge = new ArrayList<>();
    private static int totalTry;
    private static boolean success;

    Bridge bridge = new Bridge();

    public CrossBridge() {
        CrossBridge.totalTry = 0;
        CrossBridge.success = false;
        crossBridge.clear();
    }

    public void addCrossBridge(String where) {
        int goIndex = getCrossBridgeSize();
        if (bridge.isValid(goIndex, where)) {
            CrossBridge.crossBridge.add(new Way(where, true));
            return;
        }
        CrossBridge.crossBridge.add(new Way(where, false));
    }

    public List<Way> getCrossBridge() {
        return crossBridge;
    }

    public Way getCrossBridgeIndex(int index) {
        return crossBridge.get(index);
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

    public String getSuccess() {
        if (success) {
            return "성공";
        }
        return "실패";
    }

    public void setSuccess(int bridgeSize) {
        if (bridgeSize == getCrossBridgeSize()) {
            CrossBridge.success = true;
        }
    }
}
