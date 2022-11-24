package bridge.domain.type;

import bridge.validator.GameCommandValidator;

import java.util.Arrays;

public enum GameCommandType {
    RESTART("R"),
    QUIT("Q");

    final String command;

    GameCommandType(String command) {
        this.command = command;
    }

    public static GameCommandType findByCommand(String inputCommand) {
        GameCommandValidator gameCommandValidator = new GameCommandValidator();
        String command = gameCommandValidator.getValidCommand(inputCommand);
        return Arrays.stream(GameCommandType.values())
                .filter(gameCommandType -> gameCommandType.command.equals(command))
                .findAny()
                .orElse(GameCommandType.QUIT);
    }

    public String getCommand() {
        return this.command;
    }
}
