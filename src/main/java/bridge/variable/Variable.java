package bridge.variable;

public enum Variable {
    FAIL(" X "),
    SUCCESS(" O "),
    BLANK("   "),
    UP("U"),
    DOWN("D"),
    RESTART("R"),
    QUIT("Q"),
    START_BRACKET("["),
    MID_BRACKET("|"),
    END_BRACKET("]");

    private String str;

    Variable(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}
