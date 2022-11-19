package bridge.command;

public enum MovingCommand {
    UpStairs("U"),
    DownStairs("D");

    private String command;

    MovingCommand(String command) {
        this.command = command;
    }

    public String get() {
        return command;
    }
}
