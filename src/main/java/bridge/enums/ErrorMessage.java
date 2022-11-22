package bridge.enums;

public enum ErrorMessage {

    ER_BRIDGE_LENGTH_INPUT("[ERROR] 다리의 길이는 3이상 20이하의 정수 입니다."),
    ER_NOT_UP_OR_DOWN("[ERROR] 위('U') 또는 아래('D')만 입력 가능합니다."),
    ER_NOT_Q_OR_R("[ERROR] 재시작('R') 또는 종료('Q') 만 입력 가능합니다.");
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}