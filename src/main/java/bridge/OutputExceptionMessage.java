package bridge;

public enum OutputExceptionMessage {
    NOT_RANGE_EXCEPTION("1~20사이의 정수가 아닙니다."),
    NOT_NUMBER_EXCEPTION("숫자가 아닙니다!"),
    INVALID_GAME_KEY_EXCEPTION("U나 D를 누르세요!"),
    INVALID_RETRY_REQUEST_INPUT_KEY_EXCEPTION("R이나 Q를 누르세요!");

    private final String ERROR_MESSAGE = "[ERROR]";
    private final String outputMessage;

    OutputExceptionMessage(String message) {
        this.outputMessage =
                ERROR_MESSAGE
                        + " "
                        + message;
    }

    public IllegalArgumentException getException() {
        return new IllegalArgumentException(outputMessage);
    }
}
