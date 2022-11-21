package bridge.enums;

public enum GameCommandResult {
    RETRY("R", 1),
    QUIT("Q", "실패");

    private String gameCommand;
    private int attemptPlus;
    private String result;

    GameCommandResult(String gameCommand, int attemptPlus) {
        this.gameCommand = gameCommand;
        this.attemptPlus = attemptPlus;
    }

    GameCommandResult(String gameCommand, String result) {
        this.gameCommand = gameCommand;
        this.result = result;
    }

    public String getGameCommand() {
        return gameCommand;
    }

    public int getAttemptPlus() {
        return attemptPlus;
    }

    public String getResult() {
        return result;
    }
}
