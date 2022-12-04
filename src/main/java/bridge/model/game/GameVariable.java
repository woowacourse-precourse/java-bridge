package bridge.model.game;

import bridge.model.bridge.BridgeDirection;
import bridge.model.map.Maps;
import bridge.model.status.GameStatus;
import bridge.model.status.RoundStatus;

public class GameVariable {

    private enum GameSuccessDisplay {
        GAME_SUCCESS("성공"), GAME_FAIL("실패");
        private final String display;

        GameSuccessDisplay(String display) {
            this.display = display;
        }
    }

    private int numberOfAttempts;
    private Maps maps;
    private GameStatus gameStatus;

    private GameVariable(int numberOfAttempts, Maps maps) {
        this.numberOfAttempts = numberOfAttempts;
        this.maps = maps;
        this.gameStatus = GameStatus.SETTING_GAME;
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

    public boolean isGameFail() {
        return this.gameStatus.isGameFail();
    }

    public boolean isExitGame() {
        return this.gameStatus.isExitGame();
    }

    public boolean isRetryGame() {
        return this.gameStatus.isRetryGame();
    }

    public String getGameSuccessDisplay() {
        if (gameStatus.isGameSuccess()) {
            return GameSuccessDisplay.GAME_SUCCESS.display;
        }
        return GameSuccessDisplay.GAME_FAIL.display;
    }
}
