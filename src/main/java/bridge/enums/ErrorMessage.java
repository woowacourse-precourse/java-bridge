package bridge.enums;

public enum ErrorMessage {

    ER_BRIDGE_LENGTH_INPUT("[ERROR] 다리의 길이는 3이상 20이하의 정수 입니다."),
    ER_NOT_D_OR_U("[ERROR] 아래('D') 또는 위('U') 만 입력 가능합니다."),
    ER_NOT_Q_OR_R("[ERROR] 재시작('R') 또는 종료('Q') 만 입력 가능합니다.");
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}