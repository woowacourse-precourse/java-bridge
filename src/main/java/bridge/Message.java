package bridge;

public enum Message {
    START_MESSAGE("다리 건너기 게임을 시작합니다.\n"),
    BRIDGE_LENGTH_MESSAGE("다리의 길이를 입력해주세요.");

    private final String message;
    Message(String message) {
        this.message = message;
    }
    @Override
    public String toString() {
        return (message);
    }
}
