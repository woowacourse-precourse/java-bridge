package bridge.util;

public enum ExceptionMessage {

    NOT_NUMERIC("입력 범위를 초과했습니다."),

    NO_BRIDGE_SIGN_NUMBER("0, 1 중의 숫자로 다리를 생성할 수 있습니다.");
    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}