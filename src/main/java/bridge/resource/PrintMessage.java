package bridge.resource;

public enum PrintMessage {
    START_MESSAGE("다리 건너기 게임을 시작합니다."),
    START_BRIDGE_INPUT("다리의 길이를 입력해주세요."),

    MOVE_BLOCK_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),

    RETRY_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),

    FINAL_GAME_RESULT_MESSAGE("최종 게임 결과");


    private final String value;

    PrintMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
