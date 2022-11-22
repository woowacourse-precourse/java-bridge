package bridge;

public enum Error {

    BRIDGE_SIZE_ERROR("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    BRIDGE_NUMBER_ERROR("[ERROR] 무작위 값은 0 또는 1이어야 합니다."),
    MOVING_ERROR("[ERROR] 이동할 칸은 U또는 D로 입력해야 합니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
