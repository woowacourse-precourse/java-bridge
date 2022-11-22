package bridge.Constant;

public enum Message {

    START("다리 건너기 게임을 시작합니다.\n\n다리의 길이를 입력해주세요."),
    MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)");

    private final String message;

    Message(final String message) {
        this.message = message;
    }

    public String print() {
        return message;
    }
}
