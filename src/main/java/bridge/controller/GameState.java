package bridge.controller;

public enum GameState {
    RUN("진행중"),
    CLEAR("성공"),
    FAIL("실패");

    private final String comment;

    GameState(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }
}
