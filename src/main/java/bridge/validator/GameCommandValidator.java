package bridge.validator;

import static bridge.constant.GameCommand.QUIT;
import static bridge.constant.GameCommand.RETRY;

import bridge.exception.WrongGameCommandException;
import java.util.List;

public class GameCommandValidator {

    public static void validateGameCommand(String gameCommand) {
        if (!List.of(RETRY, QUIT).contains(gameCommand)) {
            throw new WrongGameCommandException();
        }
    }
}
