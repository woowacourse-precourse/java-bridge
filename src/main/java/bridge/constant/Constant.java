package bridge.constant;

public enum Constant {
    UP("U"),
    DOWN("D"),
    RESTART("R"),
    QUIT("Q"),
    POSSIBLE("O"),
    IMPOSSIBLE("X"),
    SUCCESS(" 성공"),
    FAIL(" 실패");

    private String constant;

    Constant(String constant) {
        this.constant = constant;
    }

    public String getConstant() {
        return constant;
    }
}
