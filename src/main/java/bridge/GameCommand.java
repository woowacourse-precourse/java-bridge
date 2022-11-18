package bridge;

public class GameCommand {
    private static final String RE_START_MESSAGE = "R";
    private static final String QUIT_MESSAGE = "Q";
    private final String command;

    public GameCommand(String command) {
        validate(command);
        this.command = command;
    }

    public boolean isRetry() {
        return command.equals(RE_START_MESSAGE);
    }

    private void validate(String command) {
        if (!isValidCommand(command)) {
            throw new IllegalArgumentException("재시도 여부는 R 또는 Q 문자 중 하나여야 합니다.");
        }
    }

    private boolean isValidCommand(String command) {
        return command.equals(RE_START_MESSAGE) || command.equals(QUIT_MESSAGE);
    }
}
