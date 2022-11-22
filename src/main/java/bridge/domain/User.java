package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static final int DEFAULT_TRY_COUNT = 1;

    private int tryCount = DEFAULT_TRY_COUNT;
    private List<String> mapUpperBridge = new ArrayList<>();
    private List<String> mapLowerBridge = new ArrayList<>();

    public void updateTryCount(){
        tryCount++;
    }

    public void updateMapBridge(String move, boolean isSuccess){
        if(isSuccess)
            updateMapBridgeTrue(move);
        if(!isSuccess)
            updateMapBridgeFalse(move);
    }

    private void updateMapBridgeFalse(String move){
        if(move.equals("U")){
            mapUpperBridge.add("X");
            mapLowerBridge.add(" ");
        }
        if(move.equals("D")){
            mapUpperBridge.add(" ");
            mapLowerBridge.add("X");
        }
    }

    private void updateMapBridgeTrue(String move){
        if(move.equals("U")){
            mapUpperBridge.add("O");
            mapLowerBridge.add(" ");
        }
        if(move.equals("D")){
            mapUpperBridge.add(" ");
            mapLowerBridge.add("O");
        }
    }

    public void BridgeReset(){
        mapUpperBridge = new ArrayList<>();
        mapLowerBridge = new ArrayList<>();
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<String> getMapUpperBridge() {
        return mapUpperBridge;
    }

    public List<String> getMapLowerBridge() {
        return mapLowerBridge;
    }
}
