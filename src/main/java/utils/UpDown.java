package utils;

public enum UpDown {
    UP(1, "U"),
    DOWN(0, "D");

    private final int number;
    private final String letter;

    UpDown(int number, String letter) {
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
