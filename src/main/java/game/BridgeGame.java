package game;

import inMemoryDB.GameData;

public class BridgeGame {

    GameData gameData;

    public BridgeGame(GameData gameData) {
        this.gameData = gameData;
    }

    public void move(String movingInputFloor, String bridgeFloorStatus) {
        if (movingInputFloor.equals(bridgeFloorStatus)) {
            gameData.setGameData(movingInputFloor, GameResult.CORRECT_FLOOR.getResultMessage());
            return;
        }
        gameData.setGameData(movingInputFloor, GameResult.WRONG_FLOOR.getResultMessage());
    }

    public static boolean retry(String restartStatus) {
        return restartStatus.equals(Restart.RESTART.getRestartMessage());
    }
}
