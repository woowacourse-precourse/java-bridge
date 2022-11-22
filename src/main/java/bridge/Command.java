package bridge;

import java.util.Objects;

public enum Command {
    UP(1, "U"),
    DOWN(0, "D");

    private int commandNumber;
    private String commandString;

    public String getCommandString() {
        return commandString;
    }

    public int getCommandNumber() {
        return commandNumber;
    }

    private Command(int commandNumber, String commandString) {
        this.commandNumber = commandNumber;
        this.commandString = commandString;
    }

    public static Command commandUpOrDown(int number) {
        if (number == 1) {
            return UP;
        }
        return DOWN;
    }

    public static Command commandZeroOrOne(String string) {
        if (Objects.equals(string, "U")) {
            return UP;
        }
        return DOWN;
    }

    public static Command getOppositeCommand(Command command) {
        if (command == Command.UP) {
            return Command.DOWN;
        }
        return Command.UP;
    }

}
