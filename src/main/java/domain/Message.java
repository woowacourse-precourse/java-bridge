package domain;

public enum Message {
    START_BRIDGE_GAME("다리 건너기 게임을 시작합니다.\n"),
    INPUT_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    INPUT_MOVING_UP_OR_DOWN("이동할 칸을 선택해주세요. (위: U, 아래: D)");

    private String message;

    public String get() {
        return message;
    }

    Message(String message) {
        this.message = message;
    }
}
