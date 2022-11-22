package controller;

public enum Message {
    START_GAME("다리 건너기 게임을 시작합니다."),
    REQUEST_BRIDGE_SIZE("\n다리의 길이를 입력해주세요."),
    REQUEST_MOVE_DIRECTION("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");

    private final String text;

    Message(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
