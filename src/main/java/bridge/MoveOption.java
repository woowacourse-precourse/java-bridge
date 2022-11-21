package bridge;

public enum MoveOption {
    UP(1, "U"),
    DOWN(0, "D");

    private final int value;
    private final String command;

    MoveOption(int value, String command) {
        this.value = value;
        this.command = command;
    }
    public int getValue(){
        return value;
    }
    public String getCommand() {
        return command;
    }
}
