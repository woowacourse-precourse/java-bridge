package bridge.util;

public enum MoveResult {
    CORRECT('O'), CORRECT_AND_LAST('O'), WRONG('X');
    private char mark;
    MoveResult(char mark) {
        this.mark = mark;
    }
    public char getMark() {
        return mark;
    }
}