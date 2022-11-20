package bridge.constant;

public enum Message {
    START_MESSAGE("다리 건너기 게임을 시작합니다."),
    ENTER_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    ENTER_MOVE_DIRECTION("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    ENTER_RETRY_OR_QUIT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

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
