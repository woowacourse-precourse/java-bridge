package game;

public class GameOver {

    public static int isGameOver(String passData, int stage, int bridgeSize) {
        if (passData.equals(GameResult.WRONG_FLOOR.getResultMessage())) {
            return bridgeSize;
        }
        return stage;
    }
}
