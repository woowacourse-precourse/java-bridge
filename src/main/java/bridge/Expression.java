package bridge;

public enum Expression {
    UP("U"),
    DOWN("D"),
    START_POINT("["),
    SEPARATOR("|"),
    DOWN_POINT("U");

    Expression(String name) {
        this.name = name;
    }

    private String name;

    public String expression() {
        return name;
    }
}
