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
