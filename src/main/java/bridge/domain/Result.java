package bridge.domain;

public enum Result {
    FAIL("실패"), SUCCESS("성공"), ARRIVED("성공");

    final private String value;

    Result(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
