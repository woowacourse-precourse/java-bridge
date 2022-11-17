package bridge;

public enum ErrorMessage {

    ER_STRING("[ERROR] 문자 입력은 불가능 합니다. 3이상 20이하의 정수만 입력해 주세요."),
    ER_OUT_OF_RANGE("[ERROR] 다리의 길이는 3이상 20이하의 정수 입니다.");
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}