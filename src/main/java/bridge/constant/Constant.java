package bridge.constant;

public enum Constant {

    UP("U"),
    DOWN("D"),
    RETRY("R"),
    QUIT("Q"),
    WHITE_SPACE("   "),
    NEXT_LINE("\n"),
    COMMA(", "),
    DELIMITER("|"),
    CORRECT(" O "),
    WRONG(" X ");

    private final String value;

    Constant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
