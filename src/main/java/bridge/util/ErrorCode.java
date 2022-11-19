package bridge.util;

public enum ErrorCode {

    ERROR_TITLE("[ERROR] "),
    INTEGER_ONLY_REGEX("[0-9]+"),
    INPUT_ONLY_INTEGER("정수만 입력할 수 있습니다."),
    BRIDGE_SIZE_BETWEEN_3_AND_20("다리의 길이는 3 이상 20 이하만 입력할 수 있습니다."),
    INPUT_LENGTH_ONLY_1("하나의 알파벳만 입력할 수 있습니다."),
    INPUT_ONLY_U_OR_D("U 또는 D만 입력할 수 있습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
