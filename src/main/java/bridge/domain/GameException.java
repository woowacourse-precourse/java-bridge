package bridge.domain;

public enum GameException {
    INVALID_POSITIVE_INTEGER("[ERROR]", "양의 정수를 입력해 주세요."),
    INVALID_BRIDGE_SIZE("[ERROR]", "다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INVALID_DIRECTION("[ERROR]", "U(위 칸) 또는 D(아래 칸)이 입력되지 않았습니다."),
    INVALID_ASK_RETRY_KEY("[ERROR]", "R(재도전) 또는 Q(종료)가 입력되지 않았습니다."),

    SYSTEM_ERROR_BRIDGE_GENERATE("[SYSTEM ERROR]", "다리 생성중 예상치 못한 오류가 발생했습니다!"),
    SYSTEM_ERROR_GAME_RESULT("[SYSTEM ERROR]", "게임이 정상적으로 종료되지 않았습니다!");

    private final String prefix;
    private final String message;

    GameException(String prefix, String message) {
        this.prefix = prefix;
        this.message = message;
    }

    public static boolean isSystemError(GameException gameException) {
        return gameException == SYSTEM_ERROR_GAME_RESULT || gameException == SYSTEM_ERROR_BRIDGE_GENERATE;
    }

    @Override
    public String toString() {
        return prefix + " " + message;
    }
}
