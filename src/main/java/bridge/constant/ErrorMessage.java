package bridge.constant;

public enum ErrorMessage {
    INPUT_IS_EMPTY_ERROR("빈 값이 입력되었습니다."),
    INPUT_HAS_CHARACTER_ERROR("문자가 입력되었습니다.");

    private static final String ERROR = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return ERROR + message;
    }
}
