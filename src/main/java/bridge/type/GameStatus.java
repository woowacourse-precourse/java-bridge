package bridge.type;

import bridge.core.exception.Error;
import bridge.core.exception.InvalidInputException;

public enum GameStatus implements ProcessCondition {

    START("S"),
    ONGOING("O"),
    RESTART("R"),
    QUIT("Q");

    private final String statusSymbol;

    GameStatus(String statusSymbol) {
        this.statusSymbol = statusSymbol;
    }

    public static GameStatus getGameStatusByGameCommand(String statusSymbol) {
        validate(statusSymbol);
        if (statusSymbol.equals(START.statusSymbol)) return START;
        if (statusSymbol.equals(ONGOING.statusSymbol)) return ONGOING;
        if (statusSymbol.equals(RESTART.statusSymbol)) return RESTART;
        if (statusSymbol.equals(QUIT.statusSymbol)) return QUIT;
        return null;
    }

    //== validation ==//
    private static void validate(String statusSymbol) {
        if (statusSymbol.equals("R") || statusSymbol.equals("Q")) {
            return;
        }
        throw new InvalidInputException(Error.GAME_COMMAND_ERROR);
    }
}
