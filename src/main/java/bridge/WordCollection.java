package bridge;

public enum WordCollection {
    WORD_UP("U"),
    WORD_DOWN("D"),
    WORD_SUCCESS("O"),
    WORD_FAIL("X"),
    WORD_RESTART("R"),
    WORD_QUIT("Q");

    private final String word;

    private WordCollection(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}
