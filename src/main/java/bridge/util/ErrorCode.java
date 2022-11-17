package bridge.util;

public enum ErrorCode {
    // 다리 생성 관련 오류
    INVALID_BRIDGE_SIZE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
//    INVALID_BRIDGE_SIZE_TYPE("[ERROR] 다리 길이는 정수형으로만 입력하여 주십시오.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
