package bridge.domain.bridgegame;

public enum UserChoice {
    PASS("O"),
    FAIL("X"),
    NONE(" ");

    private final String gameValue;

    UserChoice(final String gameValue) {
        this.gameValue = gameValue;
    }

    public static UserChoice findGame(boolean userChoice, boolean isMatch) {
        if (!userChoice) {
            return NONE;
        }
        if (!isMatch) {
            return FAIL;
        }
        return PASS;
    }

    public String getGameValue() {
        return gameValue;
    }
}
