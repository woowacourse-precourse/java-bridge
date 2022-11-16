package bridge.type;

public enum Direction {

    DOWN(0, "D"),

    UP(1, "U");

    private final int number;

    private final String letter;

    Direction(int number, String letter) {
        this.number = number;
        this.letter = letter;
    }

    public int getNumber() {
        return number;
    }

    public String getLetter() {
        return letter;
    }
}
