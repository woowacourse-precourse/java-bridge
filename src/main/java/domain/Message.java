package domain;

public enum Message {
    START_BRIDGE_GAME("다리 건너기 게임을 시작합니다.\n"),
    INPUT_BRIDGE_LENGTH("다리의 길이를 입력해주세요.");

    private String message;

    public String get() {
        return message;
    }

    Message(String message) {
        this.message = message;
    }
}
