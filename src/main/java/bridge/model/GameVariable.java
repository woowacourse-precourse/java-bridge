package bridge.model;

import bridge.model.bridge.BridgeDirection;
import bridge.model.map.Maps;

public class GameVariable {
    private int numberOfAttempts;
    private Maps maps;

    private GameStatus gameStatus;
    private RoundStatus roundStatus;

    private GameVariable(int numberOfAttempts, Maps maps) {
        this.numberOfAttempts = numberOfAttempts;
        this.maps = maps;
        this.gameStatus = GameStatus.SETTING_GAME;
        this.roundStatus = RoundStatus.ROUND_FAIL;
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

    public void updateGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void updateRoundStatus(RoundStatus roundStatus) {
        this.roundStatus = roundStatus;
    }

    public boolean isGameFail() {
        return this.gameStatus.isGameFail();
    }
    public boolean isExitGame() {
        return this.gameStatus.isExitGame();
    }
    public boolean isRetryGame() {
        return this.gameStatus.isRetryGame();
    }
}
