package bridge.input;

public enum Command {

    UP("U"),
    DOWN("D"),
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
