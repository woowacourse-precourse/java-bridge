package bridge.domain;

public enum GameException {
    INVALID_INTEGER("정수형 숫자를 입력해 주세요."),
    INVALID_BRIDGE_SIZE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INVALID_BRIDGE_GENERATE("다리 생성 숫자는 0(DOWN) 또는 1(UP)만 가능합니다."),
    INVALID_DIRECTION("U(위 칸) 또는 D(아래 칸)중 하나의 문자를 입력해 주세요."),
    INVALID_ASK_RETRY_KEY("R(재도전) 또는 Q(종료)중 하나의 문자를 입력해 주세요."),
    INVALID_GAME_RESULT("게임이 정상적으로 클리어 또는 종료되지 않았습니다.");

    private final String message;

    GameException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
