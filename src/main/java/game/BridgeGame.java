package game;

public class BridgeGame {

    public String move(String movingInputFloor, String bridgeFloorStatus) {
        if (movingInputFloor.equals(bridgeFloorStatus)) {
            return GameResult.CORRECT_FLOOR.getResultMessage();
        }
        return GameResult.WRONG_FLOOR.getResultMessage();
    }

    public static boolean retry(String restartStatus) {
        return restartStatus.equals(Restart.RESTART.getRestartMessage());
    }
}
