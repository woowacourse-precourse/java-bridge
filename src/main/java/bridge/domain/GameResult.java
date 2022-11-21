package bridge.domain;

public class GameResult {

    private final Result result;
    private final int gameCount;

    private GameResult(Result result, int gameCount) {
        this.result = result;
        this.gameCount = gameCount;
    }

    public static GameResult of(Result result, int gameCount) {
        return new GameResult(result, gameCount);
    }

    public Result getResult() {
        return result;
    }

    public int getGameCount() {
        return gameCount;
    }
}
