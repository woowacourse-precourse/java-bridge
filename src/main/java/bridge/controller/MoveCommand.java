package bridge.controller;

public enum MoveCommand {
    UP ("U"),
    DOWN ("D");

    private final String command;

    MoveCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
