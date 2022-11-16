package bridge.Utils;

public enum ExceptionType {

    IS_NOT_NUMBER("입력한 값이 숫자가 아닙니다."),
    IS_LOWER_THAN_MIN_BRIDGE_SIZE("입력한 값이 다리의 최소 길이(3)보다 작습니다."),
    IS_HIGHER_THAN_MAX_BRIDGE_SIZE("입력한 값이 다리의 최대 길이(20)보다 큽니다."),
    IS_NOT_ONLY_ALPHABET("입력한 값에 알파벳 외의 다른 문자가 존재합니다.");

    private final String message;

    ExceptionType(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
