package bridge.model;

public enum GameCommand {
    RETRY("R"),
    QUIT("Q");

    private final String input;

    GameCommand(String input) {
        this.input = input;
    }
}
