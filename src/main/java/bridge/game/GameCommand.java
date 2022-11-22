package bridge.game;

public enum GameCommand {

    RETRY("R"),
    QUIT("Q");

    private final String letter;

    GameCommand(String letter) {
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }
}
