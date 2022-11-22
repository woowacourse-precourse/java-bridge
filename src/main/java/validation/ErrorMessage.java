package validation;

public enum ErrorMessage {

    INVALID_BRIDGE_SIZE("[ERROR] 유효한 길이를 입력해주세요"),
    INVALID_MOVING_ORDER("[ERROR] U(위 칸) 또는 D(아래 칸)을 입력해주세요"),
    INVALID_GAME_COMMAND("[ERROR] R(재시작) 또는 Q(종료)을 입력해주세요");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
