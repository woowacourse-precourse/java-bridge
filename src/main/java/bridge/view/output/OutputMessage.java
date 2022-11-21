package bridge.view.output;

import bridge.view.Message;

import java.util.List;

public enum OutputMessage implements Message {
    START("다리 건너기 게임을 시작합니다."),
    RESULT("최종 게임 결과"),
    SUCCESS_OR_FAILURE("게임 성공 여부: "),
    TRIAL("총 시도한 횟수: "),
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    @Override
    public String text() {
        return message;
    }

    public String format(String result) {
        return String.format("%s%s", message, result);
    }
}
