package bridge.messages;

public enum InputMessage {
    START_MESSAGE("다리 건너기 게임을 시작합니다."),
    BRIDGE_SIZE_INPUT_MESSAGE("다리의 길이를 입력해주세요."),
    MOVE_DIRECTION_INPUT_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)");

    String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
