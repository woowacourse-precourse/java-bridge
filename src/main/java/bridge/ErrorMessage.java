package bridge;

public enum ErrorMessage {
    OUT_OF_RANGE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    IS_NOT_NUMBER("[ERROR] 숫자만 입력할 수 있습니다."),
    INVALID_MOVE("[ERROR] 유효하지 않은 이동 값입니다."),
    INVALID_RETRY("[ERROR] 유효하지 않은 재시작 값입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String returnMessage(){
        return message;
    }
}
