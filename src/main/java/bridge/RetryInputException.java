package bridge;

public class RetryInputException {

    public static void validateRetryInput(String restartAndQuit) {
        checkInputUpAndDownCapital(restartAndQuit);
        checkInputRestartAndQuitRight(restartAndQuit);
    }

    private static void checkInputUpAndDownCapital(String restartAndQuit) {
        if (restartAndQuit.equals("r") || restartAndQuit.equals("q")) {
            throw new IllegalArgumentException(RetryInputExceptionMessage.SMALL_LETTER_EXCEPTION_MESSAGE.getRetryInputExceptionMessage());
        }
    }

    private static void checkInputRestartAndQuitRight(String restartAndQuit) {
        if (!restartAndQuit.equals("R") && !restartAndQuit.equals("Q")) {
            throw new IllegalArgumentException(RetryInputExceptionMessage.NOT_SUITABLE_ALPHABET_EXCEPTION_MESSAGE.getRetryInputExceptionMessage());
        }
    }
}
