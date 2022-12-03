package bridge.domain;

public enum Result {
    SUCCESS(Boolean.TRUE), FAIL(Boolean.FALSE),;

    private boolean value;

    Result(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }
}
