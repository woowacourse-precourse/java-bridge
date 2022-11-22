package bridge.domain.constant;

public enum GameRecordSymbol {
    START_BRACKET("[ "),
    END_BRACKET(" ]"),
    BACK_SLASH(" | "),
    SPACING(" "),
    BLANK(""),
    NEW_LINE("\n");
    private final String gameRecordSymbol;

    GameRecordSymbol(String gameRecordSymbol) {
        this.gameRecordSymbol = gameRecordSymbol;
    }

    public String getSymbol() {
        return gameRecordSymbol;
    }

}
