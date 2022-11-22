package bridge.ui;

public enum UiErrorMessage {
    BRIDGE_LENGTH_NUMBER_ERROR("[ERROR] 다리 길이는 숫자여야 합니다."),
    BRIDGE_LENGTH_RANGE_ERROR("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    WORD_LENGTH_ERROR("[ERROR] 하나의 문자를 입력하셔야 합니다."),
    CHOICE_U_OR_D_ERROR("[ERROR] 'U' 또는 'D' 중 하나의 문자를 입력하셔야 합니다."),
    CHOICE_R_OR_Q_ERROR("[ERROR] 'R' 또는 'Q' 중 하나의 문자를 입력하셔야 합니다.");

    private final String message;

    UiErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
