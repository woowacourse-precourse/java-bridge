package bridge.domain;

public enum RoundResult {
    SUCCESS("0"),
    FAILURE("X");

    private final String expression;

    RoundResult(String expression) {
        this.expression = expression;
    }
}
