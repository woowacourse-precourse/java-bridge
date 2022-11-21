package bridge.data;

public enum GameCommand {
    Retry("R"),
    Quit("Q");

    private final String string;

    GameCommand(String string) {
        this.string = string;
    }

    public Boolean equals(String input) {
        return string.equals(input);
    }
}
