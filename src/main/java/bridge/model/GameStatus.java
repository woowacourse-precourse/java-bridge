package bridge.model;

public enum GameStatus {
    RETRY("R"),
    QUIT("Q");

    private String command;

    GameStatus(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

}

