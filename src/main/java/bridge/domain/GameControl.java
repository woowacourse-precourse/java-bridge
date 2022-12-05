package bridge.domain;

public enum GameControl {
    RETRY("R"),
    QUIT("Q");

    private final String command;
    GameControl(String command) {
        this.command = command;
    }

    public static boolean isQuit(String target) {
        return target.equals(QUIT.command);
    }

    public static boolean isRetry(String target) {
        return target.equals(RETRY.command);
    }

    @Override
    public String toString() {
        return this.command;
    }
}
