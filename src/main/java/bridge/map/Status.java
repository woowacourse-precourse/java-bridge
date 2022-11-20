package bridge.map;

public enum Status {

    CROSSING("O"),
    NO_CROSSING("X"),
    BLANK(" ");

    private final String letter;

    Status(String letter) {
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }
}
