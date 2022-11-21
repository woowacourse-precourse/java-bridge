package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMapGenerator {

    List<String> upBridgeMap = new ArrayList<>();
    List<String> downBridgeMap = new ArrayList<>();

    public void crossUpBridge(String eachBridge) {
        if (eachBridge.equals("U")) {
            upBridgeMap.add("O");
            downBridgeMap.add(" ");
        } else if (eachBridge.equals("D")) {
            upBridgeMap.add("X");
            downBridgeMap.add(" ");
        }
    }

    public void crossDownBridge(String eachBridge) {
        if (eachBridge.equals("U")) {
            upBridgeMap.add(" ");
            downBridgeMap.add("X");
        } else if (eachBridge.equals("D")) {
            upBridgeMap.add(" ");
            downBridgeMap.add("O");
        }
    }

    public void generateBridgeMap(String playerMoving, String eachBridge) {
        if (playerMoving.equals("U")) {
            crossUpBridge(eachBridge);
        } else if (playerMoving.equals("D")) {
            crossDownBridge(eachBridge);
        }
    }

    public List<List<String>> getBridgeMap() {
        List<List<String>> bridgeMap = new ArrayList<>();
        bridgeMap.add(upBridgeMap);
        bridgeMap.add(downBridgeMap);
        return bridgeMap;
    }

}
