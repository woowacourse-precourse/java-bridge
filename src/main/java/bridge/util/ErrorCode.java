package bridge.util;

public enum ErrorCode {

    // 다리 생성 관련 오류
    INVALID_BRIDGE_SIZE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),

    // 다리 이동 관련 오류
    INVALID_MOVING("[ERROR] 이동할 칸은 U(위 칸)와 D(아래 칸) 중 하나의 문자만 입력할 수 있습니다."),

    // 게임 커맨드 관련 오류
    INVALID_COMMAND("[ERROR] R(재시작)과 Q(종료) 중 하나의 문자만 입력할 수 있습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}