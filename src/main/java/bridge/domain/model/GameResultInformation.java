package bridge.domain.model;

import bridge.constants.GameResult;

public class GameResultInformation {
    private static GameResult GAME_RESULT;
    private static int countOfTry = 1;

    public static void setGameResult(GameResult result) {
        GAME_RESULT = result;
    }

    public static void increaseCountOfTry() {
        countOfTry++;
    }

    public static GameResult getGameResult() {
        return GAME_RESULT;
    }

    public static int getCountOfTry() {
        return countOfTry;
    }
}
