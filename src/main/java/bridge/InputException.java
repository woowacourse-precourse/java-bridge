package bridge;

public enum InputException {

    ERROR("[ERROR]"),
    RETRY_OR_QUIT_INVALID("[ERROR] 재시도는 R, 종료는 Q를 입력하세요."),
    MOVE_INVALID("[ERROR] 이동할 칸은 위(U) 또는 아래(D)를 입력하세요."),
    BRIDGE_SIZE_NOT_NUMBER("[ERROR] 다리 길이는 숫자만 입력 가능합니다."),
    BRIDGE_SIZE_INVALID_RANGE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");

    private final String message;

    InputException(final String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}

