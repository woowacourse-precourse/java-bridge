package bridge.domain;

public enum MoveResult {
    SUCCESS("O"),
    FAIL("X"),
    OTHER(" ");

    final String result;

    MoveResult(String result) {
        this.result = result;
    }

    public static MoveResult decide(Move destination, Move moveTo) {
        if (destination == moveTo) {
            return SUCCESS;
        }

        return FAIL;
    }

    @Override
    public String toString() {
        return " " + result + " ";
    }
}
