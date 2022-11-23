package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMapGenerator {

    private final List<String> upBridgeMap = new ArrayList<>();
    private final List<String> downBridgeMap = new ArrayList<>();
    private final List<List<String>> bridgeMap = new ArrayList<>();

    public void generateBridgeMap(String playerMoving, String eachBridge) {
        if (playerMoving.equals("U")) {
            crossUpBridge(eachBridge);
        } else if (playerMoving.equals("D")) {
            crossDownBridge(eachBridge);
        }
        combineToBridgeMap();
    }

    public List<List<String>> getBridgeMap() {
        return bridgeMap;
    }

    public void clearAllBridgeMap() {
        upBridgeMap.clear();
        downBridgeMap.clear();
    }

    private void crossUpBridge(String eachBridge) {
        if (eachBridge.equals("U")) {
            upBridgeMap.add("O");
            downBridgeMap.add(" ");
        } else if (eachBridge.equals("D")) {
            upBridgeMap.add("X");
            downBridgeMap.add(" ");
        }
    }

    private void crossDownBridge(String eachBridge) {
        if (eachBridge.equals("U")) {
            upBridgeMap.add(" ");
            downBridgeMap.add("X");
        } else if (eachBridge.equals("D")) {
            upBridgeMap.add(" ");
            downBridgeMap.add("O");
        }
    }

    private void combineToBridgeMap() {
        bridgeMap.clear();
        bridgeMap.add(upBridgeMap);
        bridgeMap.add(downBridgeMap);
    }
}
