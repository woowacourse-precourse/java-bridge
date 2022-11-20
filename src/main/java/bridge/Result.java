package bridge;

public enum Result {
    SUCCESS, FAIL, IN_PROGRESS;

    public boolean isFail() {
        return this == FAIL;
    }

    public boolean isSuccess() {
        return this == SUCCESS;
    }
}
