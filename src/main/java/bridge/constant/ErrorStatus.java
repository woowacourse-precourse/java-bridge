package bridge.constant;

public enum ErrorStatus {
    BRIDGE_SIZE_OUT_RANGE("[ERROR] 다리의 길이는 3이상 20이하여야 합니다."),
    BRIDGE_NOT_NUMBER("[ERROR] 다리의 길이는 숫자여야 합니다."),
    WRONG_MOVING_LETTER("[ERROR] 다리 이동은 U나 D 중 한가지만 입력해주세요."),
    WRONG_RESTART_LETTER("[ERROR] 재시작은 R, 종료는 Q를 입력해주세요.");

    private final String message;

    ErrorStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
