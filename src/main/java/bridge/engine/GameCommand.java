package bridge.engine;

public enum GameCommand {

    Q(false),
    R(true),
    ;

    private boolean isRetry;

    GameCommand(boolean isRetry) {
        this.isRetry = isRetry;
    }

    public boolean isRetry() {
        return isRetry;
    }

    public static boolean isMatch(String target) {
        for (GameCommand command : GameCommand.values()) {
            if (command.name().equals(target)) {
                return true;
            }
        }

        return false;
    }
}
