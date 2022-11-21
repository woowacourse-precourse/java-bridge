package bridge;

public enum BridgeError {
    INVALID_BRIDGE_SIZE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INVALID_MOVING("이동할 칸은 (위: U, 아래: D) 여야 합니다."),
    INVALID_GAME_COMMAND("입력은 (재시도: R, 종료: Q) 여야 합니다.")
    ;

    private static final String ERROR_CODE = "[ERROR]";
    private final String message;

    BridgeError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_CODE + " " + message;
    }
}
