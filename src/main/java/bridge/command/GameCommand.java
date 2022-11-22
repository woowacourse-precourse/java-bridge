package bridge.command;

public enum GameCommand {
    Restart("R"),
    Quit("Q");

    private String command;

    GameCommand(String command) {
        this.command = command;
    }

    public String get() {
        return command;
    }
}
