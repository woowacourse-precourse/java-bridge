package bridge.Util;

public enum GAME_STATE {
    INITIALIZED(""),
    IN_GAME("IN_GAME"),
    RETRY("R"),
    QUIT("Q"),
    SUCCESS("END");

    private String state;

    GAME_STATE(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }



}
