package bridge.domain;

public enum Result {
    KEEP, LOSE, WIN;

    public boolean isLose() {
        return this.equals(LOSE);
    }
}
