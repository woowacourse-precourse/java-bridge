package bridge.view.output;

import bridge.view.Message;

public enum OutputMessage implements Message {
    START("다리 건너기 게임을 시작합니다."),
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    @Override
    public String text() {
        return message;
    }
}
