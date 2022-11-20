package bridge;

public enum Status {
    PROCEEDING,
    SUCCESS,
    FAIL;

    public boolean isProceeding() {
        return this == PROCEEDING;
    }
}
