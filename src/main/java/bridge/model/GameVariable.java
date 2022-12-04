package bridge.model;

import bridge.model.bridge.BridgeDirection;
import bridge.model.map.Maps;
import java.util.Map;

public class GameVariable {
    private int numberOfAttempts;
    private Maps maps;

    private GameVariable(int numberOfAttempts, Maps maps) {
        this.numberOfAttempts = numberOfAttempts;
        this.maps = maps;
    }

    public static GameVariable byInitialValue() {
        return new GameVariable(1, Maps.byInitialState());
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

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }
}
