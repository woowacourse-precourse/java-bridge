package bridge.domain;

public enum GameRetryCommand {
    R("R"), Q("Q");

    public String command;

    GameRetryCommand(String command) {
        this.command = command;
    }
}
