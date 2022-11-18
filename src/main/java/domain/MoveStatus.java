package domain;

public enum MoveStatus {
    UP(0,"D"),
    DOWN(1,"U");

    private final int commandNumber;
    private final String commandString;

    MoveStatus(int commandNumber, String commandString) {
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
