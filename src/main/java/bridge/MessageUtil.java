package bridge;

public enum MessageUtil {
    // 출력 관련
    START_GAME_INTRO("다리 건너기 게임을 시작합니다."),
    BRIDGE_SIZE_INPUT_INTRO("다리의 길이를 입력해주세요."),

    // 에러 관련
    INVALID_BRIDGE_SIZE("잘못된 입력 형식입니다. 3 ~ 20 사이의 숫자를 입력해주세요.");

    public final String message;

    MessageUtil(String message) {
        this.message = message;
    }
}
