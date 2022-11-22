package bridge;

import static bridge.ErrorMessage.INVALID_GAME_COMMAND_ERROR;

import java.util.Arrays;

public enum GameCommand {

    RETRY("R"), QUIT("Q");

    private final String inputValue;

    GameCommand(String inputValue) {
        this.inputValue = inputValue;
    }

    public static GameCommand getEnum(String inputValue) {
        return Arrays.stream(values())
                .filter(command -> command.inputValue.equals(inputValue))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_GAME_COMMAND_ERROR));
    }
}
