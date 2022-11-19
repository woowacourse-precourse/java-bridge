package bridge.domain.enums;

public enum MovingResult {
    CORRECT(" O "),
    WRONG(" X ");

    private final String result;

    MovingResult(String result) {
        this.result = result;
    }

    public String getValue() {
        return result;
    }
}
