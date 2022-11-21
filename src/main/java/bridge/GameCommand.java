package bridge;

public class GameCommand {
    private String gameCommand;

    public GameCommand(String userGameCommand) {
        Validator.validateLength(userGameCommand);
        Validator.validateGameCommand(userGameCommand);
        gameCommand = userGameCommand;
    }

    public String getGameCommand() {
        return gameCommand;
    }
}
