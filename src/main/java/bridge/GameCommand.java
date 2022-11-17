package bridge;

public class GameCommand {
    private static final String RE_START_MESSAGE = "R";
    private static final String QUIT_MESSAGE = "Q";
    private final String command;

    public GameCommand(String command) {
        validate(command);
        this.command = command;
    }

    private void validate(String command) {
        if (!isValidCommand(command)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidCommand(String command) {
        return command.equals(RE_START_MESSAGE) || command.equals(QUIT_MESSAGE);
    }
}
