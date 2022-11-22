package bridge.domain;

import java.util.Arrays;

public enum GameResult {
    SUCCESS(true, "O", "성공"),
    FAIL(false, "X", "실패");

    private final boolean value;
    private final String movingResult;
    private final String gameResult;

    GameResult(boolean value, String movingResult, String gameResult) {
        this.value = value;
        this.movingResult = movingResult;
        this.gameResult = gameResult;
    }

    public static String getMovingResultBy(boolean isMovable) {
        return Arrays.stream(GameResult.values())
                .filter(result -> result.isEqualTo(isMovable))
                .findFirst().get().getMovingResult();
    }

    public static String getGameResultBy(boolean isSucceeded) {
        return Arrays.stream(GameResult.values())
                .filter(result -> result.isEqualTo(isSucceeded))
                .findAny().get().getGameResult();
    }

    public boolean isEqualTo(boolean inputValue) {
        return this.value == inputValue;
    }

    public String getMovingResult() {
        return movingResult;
    }

    public String getGameResult() {
        return gameResult;
    }

}
