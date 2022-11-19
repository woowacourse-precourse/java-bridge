package bridge.utils.constant;

public enum Constant {
    QUIT("Q"),
    RESTART("R"),
    UP("U"),
    DOWN("D"),
    O("O"),
    X("X"),
    BLANK(" ");

    private final String value;

    Constant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
