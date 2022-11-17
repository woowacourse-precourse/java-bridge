package exception;

public class CommandException {
    private String gameCommand;

    public CommandException(String gameCommand) {
        this.gameCommand = gameCommand;
        checkGameCommand(gameCommand);
    }

    private void checkGameCommand(String moveBridge) {
        if (!(moveBridge.equals("Q") || moveBridge.equals("R"))) throw new IllegalArgumentException();
    }

    public String getGameCommand() {
        return gameCommand;
    }
}
