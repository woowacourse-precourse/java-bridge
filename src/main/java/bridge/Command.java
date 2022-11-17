package bridge;

public enum Command {
    UP("U", 0),
    DOWN("D", 1),
    RESTART("R", 2),
    QUIT("Q", 3),
    SUCCESS("O", 4),
    FAILURE("X", 5);

    private final String value;
    private final int commandNum;
    private Command(String value, int commandNum) {
        this.value = value;
        this.commandNum = commandNum;
    }

    public String getValue() {
        return value;
    }

    public int getCommandNum() {
        return commandNum;
    }
}
