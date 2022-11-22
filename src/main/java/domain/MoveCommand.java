package domain;

public enum MoveCommand {
    DOWN(0,"D"),
    UP(1,"U");

    private final int commandNumber;
    private final String commandString;

    MoveCommand(int commandNumber, String commandString) {
        this.commandNumber = commandNumber;
        this.commandString = commandString;
    }

    public int getCommandNumber() {
        return commandNumber;
    }

    public String getCommandString() {
        return commandString;
    }
}
