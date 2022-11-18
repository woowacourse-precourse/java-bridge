package bridge.map;

public enum Status {

    CAN_CROSS("O"),
    CAN_NOT_CROSS("X"),
    BLANK(" ");

    private final String letter;

    Status(String letter) {
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }
}
