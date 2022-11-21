package bridge.Entity;

public enum Space {
    UP("U", 1),
    DOWN("D", 0);

    private final String letter;
    private final int number;

    Space(String letter, int number) {
        this.letter = letter;
        this.number = number;
    }
}
