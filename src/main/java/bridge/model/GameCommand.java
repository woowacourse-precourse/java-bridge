package bridge.model;

import bridge.view.Message;

public enum GameCommand {
    RE_GAME("R"), QUIT("Q");

    private final String value;

    GameCommand(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static GameCommand getGameCommand(String inputGameCommand) {
        if (GameCommand.RE_GAME.getValue().equals(inputGameCommand)) return GameCommand.RE_GAME;
        if (GameCommand.QUIT.getValue().equals(inputGameCommand)) return GameCommand.QUIT;
        throw new IllegalArgumentException(Message.ERROR + Message.GAME_COMMAND_ERROR);
    }
}
