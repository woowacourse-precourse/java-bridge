package bridge.constant;

public enum Error {
    ERROR("[ERROR]"),
    BRIDGE_SIZE_NOT_NUMERIC("다리 길이는 숫자만 입력 가능합니다."),
    BRIDGE_SIZE_NOT_IN_RANGE("다리 길이는 3이상 20이하의 수만 가능합니다."),
    MOVE_DIRECTION_INVALID("이동할 칸은 U 또는 D만 입력 가능합니다."),
    RESTART_CODE_INVALID("재시작 또는 종료는 R 또는 Q만 입력 가능합니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
