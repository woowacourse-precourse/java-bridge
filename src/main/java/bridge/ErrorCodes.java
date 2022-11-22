package bridge;

public enum ErrorCodes {
    RETRY_ILLEGAL_INPUT("[ERROR]: 재시도 입력 시 무조건 \"Q\" 또는 \"R\"를 입력하여야 합니다.");

    String message;



    ErrorCodes(String s) {
        this.message = s;
    }

    public String getMessage() {
        return this.message;
    }
}
