package constant;

public enum StringConstant {
    CORRECT_PATH("O"),
    WRONG_PATH("X"),
    UP_SIDE("U"),
    DOWN_SIDE("D"),
    QUIT("Q"),
    RETRY("R"),
    BRIDGE_SIZE_REGEX("^[0-9]*$"),
    WIN("성공"),
    FAIL("실패"),
    START_SQUARE_BRACKET("[ "),
    DELIMETER(" | "),
    END_SQUARE_BRACKET(" ]"),
    BLANK(" ");

    public final String stringConstant;

    StringConstant(final String stringConstant) {
        this.stringConstant = stringConstant;
    }

    public String getConstant() {
        return stringConstant;
    }
}
