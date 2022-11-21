package bridge;

public enum Continue {
    RESTART("R"), QUIT("Q");

    private String command;

    Continue(String command) {
        this.command = command;
    }

    public static Continue getEnum(String command) {
        if (RESTART.command.equals(command)) {
            return RESTART;
        }
        if (QUIT.command.equals(command)) {
            return QUIT;
        }
        return null;
    }
}
