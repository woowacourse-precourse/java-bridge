package bridge.validation;

import bridge.command.GameCommand;
import bridge.view.RetryInputExceptionMessage;

public class RetryInputException {
    private static final String SMALL_LETTER_RESTART = "r";
    private static final String SMALL_LETTER_QUIT = "q";


    public static void validateRetryInput(String restartAndQuit) {
        checkInputUpAndDownCapital(restartAndQuit);
        checkInputRestartAndQuitRight(restartAndQuit);
    }

    private static void checkInputUpAndDownCapital(String restartAndQuit) {
        if (restartAndQuit.equals(SMALL_LETTER_RESTART) || restartAndQuit.equals(SMALL_LETTER_QUIT)) {
            throw new IllegalArgumentException(RetryInputExceptionMessage.SMALL_LETTER_EXCEPTION_MESSAGE.getRetryInputExceptionMessage());
        }
    }

    private static void checkInputRestartAndQuitRight(String restartAndQuit) {
        if (!restartAndQuit.equals(GameCommand.RESTART.getGameCommand()) && !restartAndQuit.equals(GameCommand.QUIT.getGameCommand())) {
            throw new IllegalArgumentException(RetryInputExceptionMessage.NOT_SUITABLE_ALPHABET_EXCEPTION_MESSAGE.getRetryInputExceptionMessage());
        }
    }
}
