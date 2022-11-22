package bridge;

public enum WordType {

    UP("U"),
    DOWN("D"),
    RESTART("R"),
    END("Q"),
    MOVE_CHECK("O"),
    NOT_MOVE_CHECK("X"),
    NOT_CHOICE_MOVE_CHECK(" "),
    SUCCESS("성공"),
    FAIL("실패");

    private final String word;

    WordType(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}
