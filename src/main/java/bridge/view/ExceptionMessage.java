package bridge.view;

public enum ExceptionMessage {
    WRONG_SIZE_INPUT("[ERROR] 3 ~ 20 사이의 정수를 입력하세요."),
    WRONG_UD_INPUT("[ERROR] U나 D를 입력해야 합니다."),
    WRONG_RQ_INPUT("[ERROR] R이나 Q를 입력해야 합니다.");

    final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
