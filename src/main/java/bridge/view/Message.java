package bridge.view;

public enum Message {

    WELCOME("다리 건너기 게임을 시작합니다."),
    READ_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    ;

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
