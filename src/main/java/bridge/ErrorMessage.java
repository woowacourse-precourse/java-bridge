package bridge;

public enum ErrorMessage {

    ER_STRING("[ERROR] 3이상 20이하의 정수만 입력해 주세요.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}