package bridge.validate;

import static bridge.message.ErrorMessage.GAME_STOP;
import static bridge.message.ErrorMessage.UNEXPECTED_GAME_COMMAND;

import bridge.value.GameCommand;
import java.util.Arrays;

public class GameValidation {

    public static void validateGameCommand(String command) {
        Arrays.stream(GameCommand.values())
                .filter(gameCommand -> gameCommand.getCharacter().equals(command))
                .findAny().orElseThrow(() -> new IllegalArgumentException(UNEXPECTED_GAME_COMMAND.getMessage()));
    }

    public static void validateGameSuccess(boolean isGameSuccess) {
        if (isGameSuccess) {
            throw new IllegalStateException(GAME_STOP.getMessage());
        }
    }
}
