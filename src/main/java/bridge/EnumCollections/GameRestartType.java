package bridge.EnumCollections;

public enum GameRestartType {
    RESTART('R'),
    QUIT('Q');

    private char restartStatus;

    GameRestartType(char restartStatus) {
        this.restartStatus = restartStatus;
    }

    public char getRestartStatus() {
        return restartStatus;
    }

    public static boolean isRestartStatus(char input) {
        return input == RESTART.getRestartStatus() || input == QUIT.getRestartStatus();
    }
}
