package bridge.view;

public enum Message {
    BRIDGE_START("[ "),
    BRIDGE_END(" ]"),
    BRIDGE_DELIMITER(" | "),
    GAME_START("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    INPUT_MOVING("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_RESULT("최종 게임 결과"),
    GAME_TRY_COUNT("총 시도한 횟수: %d"),
    GAME_SUCCESS("게임 성공 여부: %s");

    private final String text;

    Message(final String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
