package bridge.service;

public enum PlayerCommend {
    MOVE_UPPER("U"),
    MOVE_LOWER("D"),
    RESTART("R"),
    QUIT("Q");

    private final String commend;

    PlayerCommend(String commend) {
        this.commend = commend;
    }

    public String getCommend() {
        return commend;
    }
}
