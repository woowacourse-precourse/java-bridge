package bridge.type;

public enum TextType {

    UP("U"),
    DOWN("D"),
    RESTART("R"),
    EXIT("Q"),
    START_MESSAGE("다리 건너기 게임을 시작합니다."),
    BRIDGE_START("[ "),
    BRIDGE_END(" ]"),
    BRIDGE_MID(" | "),
    POSSIBLE_SPACE("O"),
    IMPOSSIBLE_SPACE("X"),
    RESULT_MESSAGE("\n최종 게임 결과"),
    RESULT_STATUS_MESSAGE("\n게임 성공 여부: "),
    TRY_COUNT_MESSAGE("총 시도한 횟수: "),
    RETRY_MESSAGE("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

    private final String text;

    TextType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
