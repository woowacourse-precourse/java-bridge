package bridge.util;

public enum CommandKeys {
    UP("U"),
    DOWN("D"),
    RETRY("R"),
    QUIT("Q");

    private final String letter;

    CommandKeys(String letter) {
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }
}
