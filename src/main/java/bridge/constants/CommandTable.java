package bridge.constants;

public enum CommandTable {
    RETRY("R", 0),
    QUIT("Q",-1),
    SUCCESS("S",1);

    private final String command;
    private final int commandNumber;

    CommandTable(String command,int commandNumber) {
        this.command = command;
        this.commandNumber = commandNumber;
    }

    public String getCommand() {
        return command;
    }

    public int getCommandNumber() {
        return commandNumber;
    }
}
