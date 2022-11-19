package bridge;

public enum BridgeCommand {
    UP("U", 1),
    DOWN("D", 0),
    MOVABLE("O", -1),
    UNMOVABLE("X", -1),
    RETRY("R", -1),
    QUIT("Q", -1),
    SUCCESS("성공", -1),
    FAIL("실패", -1);

    private final String command;
    private final int value;

    private BridgeSymbol(String command, int value) {
        this.command = command;
        this.value = value;
    }

    public String getCommand() {
        return this.command;
    }

    public int getValue() {
        return this.value;
    }

}