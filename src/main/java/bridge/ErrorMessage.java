package bridge;

public enum ErrorMessage {
    BRIDGE_SIZE_EXCEPTION("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    MOVE_CHOICE_EXCEPTION("[ERROR] 이동 명령은 U 나 D 중 하나여야 합니다."),
    MOVE_EXCEPTION("[ERROR] 현재 게임은 더 이상 이동할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
