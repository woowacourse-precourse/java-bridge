package bridge.constant;

public enum Constant {
    UP("U"),
    DOWN("D"),
    RESTART("R"),
    QUIT("Q"),
    POSSIBLE("O"),
    IMPOSSIBLE("X");

    private String constant;

    Constant(String constant) {
        this.constant = constant;
    }

    public String getConstant() {
        return constant;
    }
}
