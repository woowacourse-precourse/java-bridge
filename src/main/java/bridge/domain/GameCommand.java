package bridge.domain;

public enum GameCommand {
    RESTART("R"),
    QUIT("Q"),
    ;

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }
}
