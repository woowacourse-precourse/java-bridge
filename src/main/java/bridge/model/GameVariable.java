package bridge.model;

import bridge.model.bridge.BridgeDirection;
import bridge.model.map.Maps;

public class GameVariable {
    private int numberOfAttempts;
    private boolean gameSuccess;
    private Maps maps;

    private GameVariable(int numberOfAttempts, boolean gameSuccess, Maps maps) {
        this.numberOfAttempts = numberOfAttempts;
        this.gameSuccess = gameSuccess;
        this.maps = maps;

    }

    public static GameVariable byInitialValue() {
        return new GameVariable(0, false, Maps.byInitialState());
    }

    public void updateMaps(BridgeDirection bridgeDirection, RoundStatus roundStatus) {
        maps.updateMaps(bridgeDirection, roundStatus);
    }

    public Maps getMaps() {
        return maps;
    }

    public void addAttempts() {
        numberOfAttempts++;
    }

    public void initializeMaps() {
        this.maps = Maps.byInitialState();
    }
}
