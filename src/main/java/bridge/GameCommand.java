package bridge;

public enum GameCommand {

    RETRY("R"),
    QUIT("Q");

    private String command;

    GameCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return this.command;
    }

    public static boolean hasCommandOf(String inputCommand) {
        for (GameCommand command : GameCommand.values()) {
            if (command.equals(inputCommand)) return true;
        }
        return false;
    }
}
