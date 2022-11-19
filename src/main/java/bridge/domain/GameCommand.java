package bridge.domain;

public enum GameCommand {
    RESTART("R"),
    QUIT("Q"),
    ;
    private String command;

    GameCommand(String command) {
        this.command = command;
    }

    public static GameCommand of(String command) {
        for (GameCommand c : GameCommand.values()) {
            if (c.getCommand().equals(command)) {
                return c;
            }
        }
        throw new IllegalArgumentException("[ERROR]");
    }

    public String getCommand() {
        return command;
    }
}
