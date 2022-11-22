package bridge.view;

import java.util.List;

public class MapGenerator {
    private static final String UPPER_BOX = "U";
    private static final String LOWER_BOX = "D";
    private static final String MOVE_SUCCESS = "O";
    private static final String MOVE_FAILURE = "X";

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
        if (bridgeStatus.get(idx) == MOVE_SUCCESS) {
            addOWhenBridgeIsUpper(bridge, idx);
            addOWhenBridgeIsLower(bridge, idx);
        }
    }

    private void addOWhenBridgeIsUpper(List<String> bridge, int idx) {
        if (bridge.get(idx) == UPPER_BOX) {
            upperMap += " O";
            lowerMap += "  ";
        }
    }

    private void addOWhenBridgeIsLower(List<String> bridge, int idx) {
        if (bridge.get(idx) == LOWER_BOX) {
            upperMap += "  ";
            lowerMap += " O";
        }
    }

    public void continueOrFinishMap(List<String> bridgeStatus, int size, int idx) {
        if (bridgeStatus.get(idx) == MOVE_SUCCESS) {
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
        if (bridgeStatus.get(idx) == MOVE_FAILURE) {
            addXAndFinishWhenBridgeIsUpper(bridge, idx);
            addXAndFinishWhenBridgeIsLower(bridge, idx);
        }
    }

    private void addXAndFinishWhenBridgeIsUpper(List<String> bridge, int idx) {
        if (bridge.get(idx) == UPPER_BOX) {
            upperMap += "   ]";
            lowerMap += " X ]";
        }
    }

    private void addXAndFinishWhenBridgeIsLower(List<String> bridge, int idx) {
        if (bridge.get(idx) == LOWER_BOX) {
            upperMap += " X ]";
            lowerMap += "   ]";
        }
    }
}
