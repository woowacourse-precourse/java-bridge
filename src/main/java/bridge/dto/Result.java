package bridge.dto;

public class Result {

    private String gameResult;
    private int attempt;

    public Result(String gameResult, int attempt) {
        this.gameResult = gameResult;
        this.attempt = attempt;
    }

    public int getAttempt() {
        return attempt;
    }

    public String getGameResult() {
        return gameResult;
    }
}
