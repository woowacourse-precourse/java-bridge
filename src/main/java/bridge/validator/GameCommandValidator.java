package bridge.validator;

import bridge.exception.WrongGameCommandException;
import java.util.List;

public class GameCommandValidator {

    private static final String RETRY = "R";
    private static final String QUIT = "Q";

    public static void validateGameCommand(String gameCommand) {
        if (!List.of(RETRY, QUIT).contains(gameCommand)) {
            throw new WrongGameCommandException();
        }
    }
}
