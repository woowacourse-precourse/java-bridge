package bridge.view;

import java.util.List;

public class MapGenerator {
    private String upperMap;
    private String lowerMap;

    public String getUpperMap() {
        return upperMap;
    }

    public String getLowerMap() {
        return lowerMap;
    }

    public void initializeMap() {
        upperMap = "[";
        lowerMap = "[";
    }

    public void makeMap(List<String> bridge, List<String> bridgeStatus) {
        initializeMap();
        int size = bridgeStatus.size();

        for (int idx = 0; idx < size; idx++) {
            addOToMap(bridge, bridgeStatus, idx);
            continueOrFinishMap(bridgeStatus, size, idx);
            addXAndFinishMap(bridge, bridgeStatus, idx);
        }
    }

    public void addOToMap(List<String> bridge, List<String> bridgeStatus, int idx) {
        if (bridgeStatus.get(idx) == "O") {
            addOWhenBridgeIsUpper(bridge, idx);
            addOWhenBridgeIsLower(bridge, idx);
        }
    }

    private void addOWhenBridgeIsUpper(List<String> bridge, int idx) {
        if (bridge.get(idx) == "U") {
            upperMap += " O";
            lowerMap += "  ";
        }
    }

    private void addOWhenBridgeIsLower(List<String> bridge, int idx) {
        if (bridge.get(idx) == "D") {
            upperMap += "  ";
            lowerMap += " O";
        }
    }

    public void continueOrFinishMap(List<String> bridgeStatus, int size, int idx) {
        if (bridgeStatus.get(idx) == "O") {
            continueMap(size, idx);
            finishMap(size, idx);
        }
    }

    private void continueMap(int size, int idx) {
        if (idx != size - 1) {
            upperMap += " |";
            lowerMap += " |";
        }
    }

    private void finishMap(int size, int idx) {
        if (idx == size - 1) {
            upperMap += " ]";
            lowerMap += " ]";
        }
    }

    public void addXAndFinishMap(List<String> bridge, List<String> bridgeStatus, int idx) {
        if (bridgeStatus.get(idx) == "X") {
            addXAndFinishWhenBridgeIsUpper(bridge, idx);
            addXAndFinishWhenBridgeIsLower(bridge, idx);
        }
    }

    private void addXAndFinishWhenBridgeIsUpper(List<String> bridge, int idx) {
        if (bridge.get(idx) == "U") {
            upperMap += "   ]";
            lowerMap += " X ]";
        }
    }

    private void addXAndFinishWhenBridgeIsLower(List<String> bridge, int idx) {
        if (bridge.get(idx) == "D") {
            upperMap += " X ]";
            lowerMap += "   ]";
        }
    }
}
