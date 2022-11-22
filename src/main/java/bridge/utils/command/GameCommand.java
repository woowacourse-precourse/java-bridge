package bridge.utils.command;

import java.util.Objects;

public enum GameCommand {
    RETRY("R"),
    QUIT("Q");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public boolean isLowerCaseCommand(String inputValue) {
        return Objects.equals(command.toLowerCase(), inputValue);
    }

    public boolean equalCommand(String command) {
        return Objects.equals(this.command, command);
    }
}
