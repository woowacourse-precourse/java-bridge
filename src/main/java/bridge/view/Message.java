package bridge.view;

public enum Message {

    WELCOME("다리 건너기 게임을 시작합니다."),
    ;

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
