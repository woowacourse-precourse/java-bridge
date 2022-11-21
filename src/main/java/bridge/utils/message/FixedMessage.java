package bridge.utils.message;

public enum FixedMessage {
    GAME_START("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    INPUT_MOVING("이동할 칸을 선택해주세요. (위: %s, 아래: %s)"),
    INPUT_GAME_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)");

    private final String message;

    FixedMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
