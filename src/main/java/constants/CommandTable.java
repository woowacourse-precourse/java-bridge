package constants;

public enum CommandTable {
    RETRY("R", 0),
    QUIT("Q",-1);

    private final String initial;
    private final int commandNumber;

    CommandTable(String initial, int commandNumber) {
        this.initial = initial;
        this.commandNumber = commandNumber;
    }

    public String getInitial() {
        return initial;
    }

    public int getCommandNumber() {
        return commandNumber;
    }
}
