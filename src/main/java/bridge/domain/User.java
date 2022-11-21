package bridge.domain;

import java.util.List;

public class User {
    private int restartCount;
    private String mapUpperUserBridge;
    private String mapLowerUserBridge;

    public User() {
        this.restartCount = 0;
        this.mapUpperUserBridge = "";
        this.mapLowerUserBridge = "";
    }

    public void updateRestartCount(){
        this.restartCount ++;
    }

    public void updateMapUserBridge(String move, int isSuccess){
        if(isSuccess == 1)
            updateMapUserBridgeTrue(move);
        if(isSuccess == 0)
            updateMapUserBridgeFalse(move);
    }

    private void updateMapUserBridgeFalse(String move){
        if(move == "U"){
            mapUpperUserBridge += " | X";
            mapLowerUserBridge += " |  ";
        }
        if(move == "D"){
            mapUpperUserBridge += " |  ";
            mapLowerUserBridge += " | X";
        }
    }

    private void updateMapUserBridgeTrue(String move){
        if(move == "U"){
            mapUpperUserBridge += " | O";
            mapLowerUserBridge += " |  ";
        }
        if(move == "D"){
            mapUpperUserBridge += " |  ";
            mapLowerUserBridge += " | O";
        }
    }

    public int getRestartCount() {
        return restartCount;
    }

    public String getMapUpperUserBridge() {
        return mapUpperUserBridge;
    }

    public String getMapLowerUserBridge() {
        return mapLowerUserBridge;
    }
}
