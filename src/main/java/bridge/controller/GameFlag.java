package bridge.controller;

public enum GameFlag {
    RESTART("R"),
    QUIT("Q");

    private final String flag;

    GameFlag(String flag) {
        this.flag = flag;
    }

    public static GameFlag ofString(String flag) {
        if (flag.equals(RESTART.flag)) {
            return RESTART;
        }
        if (flag.equals(QUIT.flag)) {
            return QUIT;
        }
        throw new IllegalArgumentException("[ERROR] R 또는 Q만 허용됩니다.");
    }
}
