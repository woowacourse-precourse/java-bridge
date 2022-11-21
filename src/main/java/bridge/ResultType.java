package bridge;

public enum ResultType {
    SUCCESS("O"), FAIL("X"), EMPTY(" ");

    private final String value;

    ResultType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
