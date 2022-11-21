package bridge.domain;

public enum GameCommand {
    R("R"), Q("Q");

    private String command;

    GameCommand(String command) {
        this.command = command;
    }

    public static GameCommand from(String command) {
        return GameCommand.valueOf(command);
    }

    public static boolean isRetry(String command) {
        if (R.equals(GameCommand.valueOf(command))) {
            return true;
        }
        return false;
    }

    public static boolean isQuit(String command) {
        if (Q.equals(GameCommand.valueOf(command))) {
            return true;
        }
        return false;
    }
}
