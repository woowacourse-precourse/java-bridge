package bridge.type;

public enum ErrorType {
    NOT_NUMBER_INPUT("[ERROR] 숫자가 아닌 다른 값을 입력하였습니다."),
    OVER_SIZE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");

    private final String error;

    ErrorType(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
