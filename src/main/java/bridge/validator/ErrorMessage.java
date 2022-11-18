package bridge.validator;

public enum ErrorMessage {
    NOT_NUMBER("[ERROR] 숫자만 입력해야 합니다."),
    NOT_IN_RANGE_3_TO_20("[ERROR] 3이상 20이하의 숫자가 아닙니다."),
    NOT_U_OR_D("[ERROR] U나 D가 아닙니다."),
    NOT_R_OR_Q("[ERROR] R이나 Q가 아닙니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return message;
    }
}
