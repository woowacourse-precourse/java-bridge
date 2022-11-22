package bridge.validator;

public enum InputException {

    NUMBER("입력값이 정수가 아닙니다."),
    UPPERCASE("입력값이 대문자가 아닙니다."),
    SINGLE_CHARACTER("입력값이 한 글자가 아닙니다."),
    ;

    private final String message;

    InputException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
