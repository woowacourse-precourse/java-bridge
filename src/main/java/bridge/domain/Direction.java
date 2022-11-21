package bridge.domain;

public enum Direction {
    UP(1, "U"),
    DOWN(0, "D");

    private final int number;

    private final String word;

    Direction(int number, String word) {
        this.number = number;
        this.word = word;
    }

    public int getNumber() {
        return number;
    }

    public String getWord() {
        return word;
    }


}
