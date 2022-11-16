package bridge.input;

public enum Command {

    UP("U", 1),
    DOWN("D", 0),
    RETRY("R"),
    QUIT("Q");

    private final String letter;
    private int number;

    Command(String letter) {
        this.letter = letter;
    }

    Command(String letter, int number) {
        this(letter);
        this.number = number;
    }

    public String getLetter() {
        return letter;
    }

    public int getNumber() {
        return number;
    }
}
