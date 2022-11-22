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

    public String toKoreanString() {
        if (this == SUCCESS) {
            return "성공";
        }
        if (this == FAIL) {
            return "실패";
        }
        return "";
    }
}
