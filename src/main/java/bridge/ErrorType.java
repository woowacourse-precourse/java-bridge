package bridge;

public enum ErrorType {
    NOT_BRIDGE_SIZE("[ERROR] 다리 길이는 %d부터 %d 사이의 숫자여야 합니다."),
    NOT_MOVING("[ERROR] U(위 칸)와 D(아래 칸) 중 하나의 문자여야 합니다."),
    NOT_GAME_COMMAND("[ERROR] R(재시작)과 Q(종료) 중 하나의 문자여야 합니다."),
    NOT_VALUE("[ERROR] 잘못된 값 입니다.");

    private final String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
