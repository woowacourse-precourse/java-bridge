package bridge.Util;

public enum GAME_STATE {
    INITIALIZED("", 0),
    IN_GAME("IN_GAME", 0),
    RETRY("R", 0),
    QUIT("실패", 0),
    SUCCESS("성공", 0),
    INDEX("INDEX", 0);

    private String state;
    private int value;

    GAME_STATE(String state, int value) {
        this.state = state;
        this.value = value;
    }

    public String getState() {
        return state;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
