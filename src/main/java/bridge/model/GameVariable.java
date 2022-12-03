package bridge.model;

import bridge.model.map.Maps;

public class GameVariable {
    private final int numberOfAttempts;
    private final boolean gameSuccess;
    private final Maps maps;

    private GameVariable(int numberOfAttempts, boolean gameSuccess, Maps maps) {
        this.numberOfAttempts = numberOfAttempts;
        this.gameSuccess = gameSuccess;
        this.maps = maps;

    }

    public static GameVariable byInitialValue() {
        return new GameVariable(0, false, Maps.byInitialState());
    }
}
