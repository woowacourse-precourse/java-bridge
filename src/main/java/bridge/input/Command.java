package bridge.input;

public enum Command {

    UP("U"),
    DOWN("D");

    private final String letter;

    Command(String letter) {
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }
}
