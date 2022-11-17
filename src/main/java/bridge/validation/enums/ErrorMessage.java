package bridge.validation.enums;

public enum ErrorMessage {
    NULL_EXCEPTION("[ERROR] 빈 문자열이 입력되었습니다. 3부터 20사이의 숫자를 입력해 주세요."),
    BLANK_EXCEPTION("[ERROR] 공백의 문자열이 입력되었습니다. 3부터 20사이의 숫자를 입력해 주세요."),
    NUMBER_EXCEPTION("[ERROR] 입력이 숫자가 아닙니다. 3부터 20사이의 숫자를 입력해 주세요."),
    RANGE_EXCEPTION("[ERROR] 입력 범위에 벗어난 값입니다. 3부터 20사이의 숫자를 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}