package bridge.view;

public enum InputMessage {
    READ_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    READ_MOVE_COMMEND("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
