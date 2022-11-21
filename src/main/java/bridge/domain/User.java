package bridge.domain;

public class User {
    private static final int DEFAULT_TRY_COUNT = 1;
    private static final String DEFAULT_MAP_BRIDGE = "";

    private int tryCount;
    private String mapUpperBridge;
    private String mapLowerBridge;

    public User() {
        this.tryCount = DEFAULT_TRY_COUNT;
        this.mapUpperBridge = DEFAULT_MAP_BRIDGE;
        this.mapLowerBridge = DEFAULT_MAP_BRIDGE;
    }

    public void updateTryCount(){
        this.tryCount++;
    }

    public void updateMapBridge(String move, int isSuccess){
        if(isSuccess == 1)
            updateMapBridgeTrue(move);
        if(isSuccess == 0)
            updateMapBridgeFalse(move);
    }

    private void updateMapBridgeFalse(String move){
        if(move == "U"){
            mapUpperBridge += " | X";
            mapLowerBridge += " |  ";
        }
        if(move == "D"){
            mapUpperBridge += " |  ";
            mapLowerBridge += " | X";
        }
    }

    private void updateMapBridgeTrue(String move){
        if(move == "U"){
            mapUpperBridge += " | O";
            mapLowerBridge += " |  ";
        }
        if(move == "D"){
            mapUpperBridge += " |  ";
            mapLowerBridge += " | O";
        }
    }

    public int getTryCount() {
        return tryCount;
    }

    public String getMapUpperBridge() {
        return mapUpperBridge;
    }

    public String getMapLowerBridge() {
        return mapLowerBridge;
    }
}
