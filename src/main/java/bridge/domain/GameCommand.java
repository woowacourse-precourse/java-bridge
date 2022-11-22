package bridge.domain;

public enum GameCommand {
    RETRY("R", "재시작"),
    QUIT("Q", "종료");

    private final String expression;
    private final String description;

    GameCommand(String expression, String description) {
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
