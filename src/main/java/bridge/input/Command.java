package bridge.input;

public enum Command {

    RETRY("R"),
    QUIT("Q");

    private final String letter;

    Command(String letter) {
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }
}
