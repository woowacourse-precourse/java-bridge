package bridge.domain;

public enum GameException {
    INVALID_INTEGER("올바른 정수형 숫자가 아닙니다."),
    INVALID_BRIDGE_SIZE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INVALID_DIRECTION("U(위 칸) 또는 D(아래 칸)이 입력되지 않았습니다."),
    INVALID_ASK_RETRY_KEY("R(재도전) 또는 Q(종료)가 입력되지 않았습니다."),

    SYSTEM_ERROR_BRIDGE_GENERATE("다리 생성중 예상치 못한 오류가 발생했습니다!"),
    SYSTEM_ERROR_GAME_RESULT("게임이 정상적으로 종료되지 않았습니다!");

    private final String message;

    GameException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static boolean isSystemError(String message) {
        return SYSTEM_ERROR_BRIDGE_GENERATE.message.equals(message) || SYSTEM_ERROR_GAME_RESULT.message.equals(message);
    }
}
