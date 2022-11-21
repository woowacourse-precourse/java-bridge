package bridge.domain;

public enum GameResult {
    KEEP, LOSE, WIN;

    public static GameResult retryOrNot(String readGameCommand) {
        if (readGameCommand.equals("R")) {
            return GameResult.KEEP;
        }
        return GameResult.LOSE;
    }

    public boolean isLose() {
        return this.equals(LOSE);
    }
    public boolean isWin() {
        return this.equals(WIN);
    }

    public boolean isNotKeep() {
        return isLose()||isWin();
    }

    public boolean isKeep() {
        return this.equals(KEEP);
    }
}
