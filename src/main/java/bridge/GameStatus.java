package bridge;

public enum GameStatus {
    GAME_FAIL(0),
    GAME_SUCCESS(1),
    GAME_CONTINUE(2),
    GAME_INVALID(3);

    private final int status;
    GameStatus(int status) {
        this.status = status;
    }
    public boolean isContinue() {
        return (status == 2);
    }
    public boolean isFail() {
        return (status == 0);
    }
    public boolean isInvalid() {
        return (status == 3);
    }
    @Override
    public String toString() {
        if (status == 1) {
            return ("성공");
        }
        if (status == 0) {
            return ("실패");
        }
        return ("");
    }
}
