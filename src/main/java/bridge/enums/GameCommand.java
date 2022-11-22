package bridge.enums;

public enum GameCommand {
    Retrial("R"),
    Quit("Q");

    private final String expression;

    private GameCommand(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }
}
