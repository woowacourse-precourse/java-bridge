package bridge;

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

    public static Command isUpOrDown(int number) {
        if (number == 1) {
            return UP;
        }
        return DOWN;
    }

}
