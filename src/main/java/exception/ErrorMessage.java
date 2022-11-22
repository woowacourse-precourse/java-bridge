package exception;

public enum ErrorMessage {

    INPUT_WRONG_BRIDGE_SIZE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");

    private String errorMessage;

    public String get() {
        return errorMessage;
    }

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
