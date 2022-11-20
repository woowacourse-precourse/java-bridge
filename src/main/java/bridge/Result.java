package bridge;

public enum Result {
    SUCCESS, FAIL;

    public boolean isFail() {
        return this == FAIL;
    }

    public boolean isSuccess() {
        return this == SUCCESS;
    }
}
