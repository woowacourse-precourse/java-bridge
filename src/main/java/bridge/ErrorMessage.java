package bridge;

public enum ErrorMessage {
    INVALID_NUMBER_TYPE("숫자만 입력 가능합니다"),
    INVALID_NUMBER_PREFIX("유효하지 않은 숫자입니다"),
    INVALID_BRIDGE_SIZE("3이상 20이하의 숫자만 입력 가능합니다"),
    INVALID_MOVING_POSITION("U 또는 D만 입력 가능합니다(대소문자 주의)"),
    INVALID_GAME_COMMAND("R 또는 Q만 입력 가능합니다(대소문자 주의)");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefex() + message;
    }

    public String prefex() {
        return "[ERROR]";
    }
}
