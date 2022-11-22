package bridge.enums;

public enum ExceptionMessage {
    ERROR_NOT_INPUT_UP_OR_DOWN("[ERROR] %s 또는 %s만 입력해주세요."),
    ERROR_NOT_RANGE_SIZE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");

    final private String errorMessage;

    ExceptionMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public static String errorInputUpOrDown() {
        return String.format(ERROR_NOT_INPUT_UP_OR_DOWN.getErrorMessage(),
                Answer.Up.getAnswer(), Answer.Down.getAnswer());
    }

    public static String errorInputRetryOrQuit() {
        return String.format(ERROR_NOT_INPUT_UP_OR_DOWN.getErrorMessage(),
                Answer.Retry.getAnswer(), Answer.Quit.getAnswer());
    }
}
