package bridge.enums;

public enum GameCommand {
    RETRIAL("R"),
    QUIT("Q");

    private final String expression;

    GameCommand(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

}
