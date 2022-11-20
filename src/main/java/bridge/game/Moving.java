package bridge.game;

public enum Moving {

    UP("U", 1),
    DOWN("D", 0);

    private final String letter;
    private final int number;

    Moving(String letter, int number) {
        this.letter = letter;
        this.number = number;
    }

    public String getLetter() {
        return letter;
    }

    public int getNumber() {
        return number;
    }
}
