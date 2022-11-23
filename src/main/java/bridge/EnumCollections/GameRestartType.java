package bridge.EnumCollections;

public enum GameRestartType {
    RESTART("R"),
    QUIT("Q");

    private String restartStatus;

    GameRestartType(String restartStatus) {
        this.restartStatus = restartStatus;
    }

    public String getRestartStatus() {
        return restartStatus;
    }

    public static boolean isRestartStatus(String input) {
        return input.equals(RESTART.getRestartStatus()) || input.equals(QUIT.getRestartStatus());
    }
}
