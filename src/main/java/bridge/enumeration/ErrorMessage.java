package bridge.enumeration;

public enum ErrorMessage {
    BRIDGE_OUT_OF_RANGE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    NOT_NUMBER("입력값은 숫자여야 합니다."),
    NOT_U_OR_D("입력값은 'U'또는 'D'여야 합니다."),
    NOT_R_OR_Q("입력값은 'R'또는 'Q'여야 합니다."),
    INPUT_OUT_OF_RANGE("입력값은 한 개의 문자여야 합니다.");

    private final String errorMessage;
    private final String errorPrefix = "[ERROR] ";

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorPrefix + this.errorMessage;
    }
}
