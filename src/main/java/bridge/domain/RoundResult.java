package bridge.domain;

public enum RoundResult {
    SUCCESS("O", "성공"),
    FAILURE("X", "실패");

    private final String expression;
    private final String description;

    RoundResult(String expression, String description) {
        this.expression = expression;
        this.description = description;
    }

    public String getExpression() {
        return expression;
    }

    public String getDescription() {
        return description;
    }
}
