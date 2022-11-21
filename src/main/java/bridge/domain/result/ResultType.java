package bridge.domain.result;

public enum ResultType {
    SUCCESS("O"),
    FAIL("X"),
    BLANK(" "),
    FINISHED("O");

    private final String value;

    ResultType(String value) {
        this.value = value;
    }

    public boolean isSucceeded() {
        return this.equals(SUCCESS);

    }
    public boolean isFinished() {
        return this.equals(FINISHED);
    }
    @Override
    public String toString() {
        return value;
    }


}
