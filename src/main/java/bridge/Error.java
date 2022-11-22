package bridge;

public enum Error {

    BRIDGE_OUT_OF_RANGE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INPUT_IS_NOT_NUM("[ERROR] 입력값이 숫자가 아닙니다."),
    INVALID_MOVING("[ERROR] 이동할 칸은 U 혹은 D 여야 합니다.");
    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
