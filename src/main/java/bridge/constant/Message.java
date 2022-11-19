package bridge.constant;

public enum Message {
    ENTER_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    ENTER_MOVE_DIRECTION("이동할 칸을 선택해주세요. (위: U, 아래: D)");

    private final String message;
    private static final String NEW_LINE = "\n";

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return NEW_LINE + message;
    }
}
