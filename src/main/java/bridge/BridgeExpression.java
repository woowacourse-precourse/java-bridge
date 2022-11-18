package bridge;

public enum BridgeExpression {

    UP("U"),
    DOWN("D"),
    SEPARATOR("|"),
    START_POINT("["),
    END_POINT("]");

    private String name;

    BridgeExpression(String name) {
        this.name = name;
    }

    public String expreesion() {
        return name;
    }
}
