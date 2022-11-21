package bridge.domain;

public enum Result {
    KEEP, LOSE, WIN;

    public boolean isLose() {
        return this.equals(LOSE);
    }
    public boolean isWin() {
        return this.equals(WIN);
    }

    public boolean isEnd() {
        return isLose()||isWin();
    }
}
