package bridge;

public enum Result {
    SUCCESS("O", "성공"),
    FAILURE("X", "실패");

    private final String character;
    private final String word;

    Result(String character, String word) {
        this.character = character;
        this.word = word;
    }

    public String getCharacter() {
        return character;
    }

    public String getWord() {
        return word;
    }
}
