package bridge.model;

import static bridge.util.ErrorMessage.ERROR_GAME_COMMAND_INPUT;

import java.util.Arrays;

public enum GameCommand {
    RETRY("R"),
    QUIT("Q");

    private final String input;


    GameCommand(String input) {
        this.input = input;
    }


    public static GameCommand from(String input) {
        return Arrays.stream(GameCommand.values())
                .filter(command -> command.input.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_GAME_COMMAND_INPUT));
    }

    public static boolean isRetry(GameCommand command) {
        return command == GameCommand.RETRY;
    }


}
