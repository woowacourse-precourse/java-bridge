package bridge.model;

public enum ExceptionMessage {
    NOT_NUMBER("숫자만 입력되어야 합니다."),
    WRONG_MOVING_COMMAND("(위: U, 아래: D) 문자만 입력 가능합니다."),
    WRONG_GAME_COMMAND("(재시도: R, 종료: Q) 문자만 입력 가능합니다."),
    OUT_OF_BOUNDARY("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
