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

    public static MoveResult move(String realDirection, String moveDirection) {
        if (realDirection.equals(moveDirection)) {
            return SUCCESS;
        }

        return FAIL;
    }

    @Override
    public String toString() {
        return result;
    }
}
