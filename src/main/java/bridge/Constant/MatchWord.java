package bridge.Constant;

public enum MatchWord {
    Up(1, "U"),
    Down(0, "D");

    private final int value;
    private final String word;

    MatchWord(int value, String word) {
        this.value = value;
        this.word = word;
    }

    public int getValue() {
        return value;
    }

    public String getWord() {
        return word;
    }
}
