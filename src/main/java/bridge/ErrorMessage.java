package bridge;

public enum ErrorMessage {

    BRIDGE_LENGTH_RANGE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    BRIDGE_CROSS_INPUT("[ERROR] 이동할 칸은 U나 D로만 입력해주세요"),
    BRIDGE_RESTART_INPUT("[ERROR] 재시도에 대한 입력은 R이나 Q로만 입력해주세요.");

    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
