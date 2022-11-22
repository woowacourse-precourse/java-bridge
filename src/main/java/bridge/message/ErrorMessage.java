package bridge.message;

public enum ErrorMessage {
    LENGTH_ERROR("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    NUMBER_ERROR("[ERROR] 숫자로만 입력해주세요."),
    UPDOWN_ERROR("[ERROR] 다리 진행은 U 또는 D 중 한 글자만 입력가능합니다."),
    RETRY_ERROR("[ERROR] 다시 시작은 R, 종료는 Q를 입력해주세요."),
    MAKE_BRIDGE_ERROR("[ERROR] 다리를 만들 때는 0 또는 1만 사용할 수 있습니다.");

    private final String errorMessage;

    public String get() {
        return errorMessage;
    }

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
