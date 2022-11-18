package bridge;

// 다리 표현식
public enum BridgeExpression {
    UP("U"),
    DOWN("D"),
    RE_TRY("R"),
    START_POINT("["),
    SEPARATOR("|"),
    END_POINT("]"),
    CROSS_TRUE("O"),
    CROSS_FALSE("X");

    private final String name;

    BridgeExpression(String name) {
        this.name = name;
    }

    public String expression() {
        return name;
    }
}
