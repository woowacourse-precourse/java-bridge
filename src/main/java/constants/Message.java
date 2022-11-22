package constants;

public enum Message {
    START_GAME("다리 건너기 게임을 시작합니다."),
    REQUEST_BRIDGE_SIZE("\n다리의 길이를 입력해주세요."),
    REQUEST_MOVE_DIRECTION("\n이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    REQUEST_RETRY_OR_END("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

    private final String text;

    Message(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
