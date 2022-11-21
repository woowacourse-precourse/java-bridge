package bridge;

public enum OutputMessage {
    START_MESSAGE("다리 건너기 게임을 시작합니다.\n"),
    BRIDGE_LENGTH_MESSAGE("다리의 길이를 입력해주세요."),
    CHOICE_REQUEST_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)");

    private final String message;
    OutputMessage(String message) {
        this.message = message;
    }
    @Override
    public String toString() {
        return (message);
    }
}
