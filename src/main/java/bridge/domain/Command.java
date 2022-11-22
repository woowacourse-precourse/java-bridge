package bridge.domain;

public enum Command {
    RESTART, QUIT;

    public static Command of (boolean type) {
        if (type) {
            return RESTART;
        }
        return QUIT;
    }
}