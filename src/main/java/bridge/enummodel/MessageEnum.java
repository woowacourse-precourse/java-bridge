package bridge.enummodel;

public enum MessageEnum {

    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    SELECT_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RETRY_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

    private final String value;

    MessageEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
