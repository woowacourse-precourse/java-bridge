package bridge.domain;

public enum MoveResult {
    SUCCESS("O", true),
    FAIL("X", false),
    OTHER(" ", false);

    final String result;
    final boolean canMove;

    MoveResult(String result, boolean canMove) {
        this.result = result;
        this.canMove = canMove;
    }

    public static MoveResult move(Move destination, Move moveTo) {
        if (destination == moveTo) {
            return SUCCESS;
        }

        return FAIL;
    }

    @Override
    public String toString() {
        return result;
    }
}
