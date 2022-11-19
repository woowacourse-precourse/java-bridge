package bridge.controller;

import static bridge.ExceptionConst.*;

public enum GameFlag {
    RESTART("R"),
    QUIT("Q"),
    NOTHING("");

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
        throw new IllegalArgumentException(EXCEPTION_MESSAGE_R_OR_Q);
    }
}
