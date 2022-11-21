package bridge.exception;

public class GameCommand {
    private static final String RESTART_GAME = "R";
    private static final String END_GAME = "Q";

    private final String gameCommand;

    public GameCommand(String gameCommand) {
        this.gameCommand = gameCommand;
    }

    private boolean checkInvalidGameCommand() {
        return gameCommand.equals(RESTART_GAME) || gameCommand.equals(END_GAME);
    }
}
