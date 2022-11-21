package bridge.Model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class BridgeResult {
    private static final String UPPER_BRIDGE = "U";
    private static final String LOWER_BRIDGE = "D";

    private final LinkedHashMap<String, List<String>> currentMap;

    public BridgeResult(){
        currentMap = new LinkedHashMap<>(){{
            put(UPPER_BRIDGE, new ArrayList<>());
            put(LOWER_BRIDGE, new ArrayList<>());
        }};
    }

    public BridgeResult(List<String> upperBridgeState, List<String> lowerBridgeState){
        currentMap = new LinkedHashMap<>(){{
            put(UPPER_BRIDGE, upperBridgeState);
            put(LOWER_BRIDGE, lowerBridgeState);
        }};
    }

    public void selectUpperBridge(String result){
        currentMap.get(UPPER_BRIDGE).add(result);
        currentMap.get(LOWER_BRIDGE).add(" ");
    }

    public void selectLowerBridge(String result){
        currentMap.get(UPPER_BRIDGE).add(" ");
        currentMap.get(LOWER_BRIDGE).add(result);
    }

    @Override
    public String toString(){
        return currentMap.toString();
    }
}
