package bridge.validation;

public enum Message {
    ERROR_MESSAGE("[ERROR] "),

    AND(", "),
    ENTER_ONE_OF_THE_MARKS(" 중 하나의 문자를 입력해주세요."),
    ENTER_INTEGER("숫자를 입력해주세요."),
    OR_OVER(" 이상 "),
    OR_LESS(" 이하의 숫자를 입력할 수 있습니다."),
    ENTER_ONE_CHARACTER("한 문자로 입력해주세요.");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
