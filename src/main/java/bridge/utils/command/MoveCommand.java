package bridge.utils.command;

import java.util.Objects;

public enum MoveCommand {
    UP(1, "U"),
    DOWN(0, "D");

    private final int number;
    private final String command;

    MoveCommand(int number, String command) {
        this.number = number;
        this.command = command;
    }

    public String getCommand() {
        return this.command;
    }

    public boolean isLowerCaseCommand(String inputValue) {
        return Objects.equals(command.toLowerCase(), inputValue);
    }

    public boolean equalCommand(String command) {
        return Objects.equals(this.command, command);
    }

    public boolean equalNumber(int number) {
        return Objects.equals(this.number, number);
    }
}
