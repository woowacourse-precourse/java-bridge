package constant;

public enum PrintConstant {
    WIN("성공"),
    FAIL("실패"),
    CORRECT_PATH("O"),
    WRONG_PATH("X"),
    START_SQUARE_BRACKET("[ "),
    END_SQUARE_BRACKET(" ]"),
    DELIMETER(" | "),
    BLANK(" ");

    public final String PrintConstant;

    PrintConstant(final String PrintConstant) {
        this.PrintConstant = PrintConstant;
    }

    public String getConstant() {
        return PrintConstant;
    }
}
