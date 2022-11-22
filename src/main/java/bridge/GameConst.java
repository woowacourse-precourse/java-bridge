package bridge;

public enum GameConst {
    CHOOSE_UP("U"),
    CHOOSE_DOWN ("D"),
    CHOOSE_RESTART("R"),
    CHOOSE_END("Q");
    private final String GameConst;

    GameConst(String message) {
        this.GameConst = message;
    }

    public String getMessage() {
        return GameConst;
}
}
