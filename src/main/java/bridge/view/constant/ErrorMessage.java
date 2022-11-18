package bridge.view.constant;

public enum ErrorMessage {
    INVALID_BRIDGE_SIZE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INVALID_NEXT_MOVE("[ERROR] U(위 칸)와 D(아래 칸) 중 하나의 문자를 입력해야 합니다."),
    INVALID_GAME_COMMAND("[ERROR] R(재시작)과 Q(종료) 중 하나의 문자를 입력해야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
