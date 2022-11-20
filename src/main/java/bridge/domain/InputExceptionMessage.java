package bridge.domain;

public enum InputExceptionMessage {
    WRONG_BRIDGE_SIZE("[ERROR] 다리 길이는 3과 20 사이의 숫자여야 합니다."),
    WRONG_MOVING("[ERROR] 다리 이동은 'U(위)' 또는 'D(아래)'여야 합니다."),
    WRONG_GAME_COMMAND("[ERROR] 재시도 관련 명령어는 'R(재시작)' 또는 'Q(종료)'여야 합니다.");

    private final String message;

    InputExceptionMessage(String message) {
        this.message = message;
    }

    String getMessage() {
        return message;
    }
}
