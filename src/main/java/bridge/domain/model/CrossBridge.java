package bridge.domain.model;

import java.util.ArrayList;
import java.util.List;

public class CrossBridge {

    private static final List<Way> crossBridge = new ArrayList<>();
    private static int totalTry = 0;
    private static boolean success = false;

    Bridge bridge = new Bridge();

    public CrossBridge() {

    }

    public void setNewGame() {
        CrossBridge.totalTry++;
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
