package bridge.domain;

public enum Block {
    GOOD("O"),
    BAD("X"),
    BLANK(" ");
    private String word;

    Block(String word) {
        this.word = word;
    }

    public String gerWord() {
        return word;
    }
}
