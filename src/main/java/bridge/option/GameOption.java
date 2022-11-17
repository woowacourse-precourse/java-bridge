package bridge.option;

public class GameOption {
    private static final String RESTART = "R";
    private static final String END = "Q";

    private final String gameOption;

    public GameOption(String gameOption) {
        Option.validate(gameOption);
        this.gameOption = gameOption;
    }
}
