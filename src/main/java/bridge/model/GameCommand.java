package bridge.model;

public class GameCommand {
    private final String command;

    public GameCommand(String command) {
        validate(command);
        this.command = command;
    }

    public boolean isRetry() {
        return command.equals(Command.R.toString());
    }

    private void validate(String command) {
        if (!isValidCommand(command)) {
            throw new IllegalArgumentException("재시도 여부는 R 또는 Q 문자 중 하나여야 합니다.");
        }
    }

    private boolean isValidCommand(String command) {
        return command.equals(Command.Q.toString()) || command.equals(Command.R.toString());
    }
}
