package bridge.constant;

import static bridge.constant.ErrorResponse.INVALID_INPUT_GAME_COMMAND;

public enum GameCommand {
    R("R"), Q("Q");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public static GameCommand from(String inputGameCommand) {
        for (GameCommand gameCommand : GameCommand.values()) {
            if (isSameCommand(inputGameCommand, gameCommand)) {
                return gameCommand;
            }
        }
        throw INVALID_INPUT_GAME_COMMAND.getValue();
    }

    private static boolean isSameCommand(String inputGameCommand, GameCommand gameCommand) {
        return gameCommand.name().equals(inputGameCommand);
    }

    public String getValue() {
        return this.command;
    }
}
