package bridge.model.constant;

public enum GameResult {
    UP("U"),
    DOWN("D"),
    CORRECT("O"),
    NOT_CORRECT("X"),
    SPACE(" ");

    private final String gameResult;

    GameResult(String gameResult) {
        this.gameResult = gameResult;
    }

    public String getGameResult() {
        return gameResult;
    }
}
