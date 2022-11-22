package bridge;

public enum ErrorCodes {

    ANSWER_ILLEGAL_INPUT("[ERROR]: 다리 길이는 3부터 20사이의 숫자여야 합니다."),
    RETRY_ILLEGAL_INPUT("[ERROR]: 재시도 입력 시 무조건 \"Q\" 또는 \"R\"를 입력하여야 합니다.");

    String message;



    ErrorCodes(String s) {
        this.message = s;
    }

    public String getMessage() {
        return this.message;
    }
}
