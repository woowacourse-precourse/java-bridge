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

    public int getNumber() {
        return number;
    }

    public boolean isLowerCaseCommand(String inputValue) {
        return Objects.equals(command.toLowerCase(), inputValue);
    }

    public boolean isValidCommand(String inputValue) {
        return Objects.equals(command, inputValue);
    }
}
