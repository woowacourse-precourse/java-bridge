package domain;

public enum MoveStatus {
    UP_O("O, ", false),
    UP_X("X, ", true),
    DOWN_O(" ,O", false),
    DOWN_X(" ,X", true);

    private final String result;
    private final boolean moveStatus;

    MoveStatus(String result, boolean moveStatus) {
        this.result = result;
        this.moveStatus = moveStatus;
    }

    public String toString() {
        return result;
    }

    public boolean isMoveStatus() {
        return moveStatus;
    }
}
