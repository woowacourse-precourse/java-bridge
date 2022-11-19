package bridge.resource;

public enum PrintMessage {
    START_MESSAGE("다리 건너기 게임을 시작합니다."),
    START_BRIDGE_INPUT("다리의 길이를 입력해주세요."),

    MOVE_BLOCK_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)");


    private final String value;

    PrintMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
