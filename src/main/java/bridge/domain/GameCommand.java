package bridge.domain;

public enum GameCommand {

    RETRY("R"),
    QUIT("Q");

    private String command;

    GameCommand(String command) {
        this.command = command;
    }

    public String command() {
        return this.command;
    }

}
