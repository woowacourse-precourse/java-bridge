package bridge;

public enum Moving {
    UP("U", 1),
    DOWN("D", 0);

    private final String directionWord;
    private final int direction;

    Moving(String directionWord, int direction) {
        this.directionWord = directionWord;
        this.direction = direction;
    }
}
