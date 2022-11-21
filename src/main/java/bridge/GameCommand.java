package bridge;

public class GameCommand {
    private static String gameCommand;

    public static void validateInput(String userGameCommand) {
        Validator.validateLength(userGameCommand);
        Validator.validateGameCommand(userGameCommand);
        gameCommand = userGameCommand;
    }

    public static String getGameCommand() {
        return gameCommand;
    }
}
