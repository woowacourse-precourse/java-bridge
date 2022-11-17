package bridge.option;

import static bridge.config.ExceptionMessage.WRONG_GAME_OPTION;

public class GameOption {
    private static final String RESTART = "R";
    private static final String END = "Q";

    private final String gameOption;

    public GameOption(String gameOption) {
        Option.validate(gameOption);
        validate(gameOption);
        this.gameOption = gameOption;
    }

    private void validate(String gameOption) {
        validateOptionAvailable(gameOption);
    }

    private void validateOptionAvailable(String gameOption) {
        if (!gameOption.equals(RESTART) && !gameOption.equals(END)) {
            throw new IllegalArgumentException(WRONG_GAME_OPTION.toString());
        }
    }
}
