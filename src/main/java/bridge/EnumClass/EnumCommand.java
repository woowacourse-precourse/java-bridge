package bridge.EnumClass;

public enum EnumCommand {
    Up("U", 1),
    Down("D", 0);

    private String command;
    private int worth;

    EnumCommand(String command, int worth) {
        this.command = command;
        this.worth = worth;
    }

    public String getCommand() {
        return command;
    }

    public int getWorth() {
        return worth;
    }
}