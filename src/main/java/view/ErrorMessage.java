package view;

public enum ErrorMessage {
    DIGIT("[ERROR] 다리 길이는 정수만 입력해주세요."),
    SIZE_RANGE("[ERROR] 다리 길이는 3~20 사이입니다."),
    NULL("[ERROR] 값을 입력하셔야 합니다."),
    COMMAND("[ERROR] 잘못된 재시작,종료 입력입니다."),
    MOVE("[ERROR] 잘못된 움직임 입력입니다.");

    private final String errorMsg;

    ErrorMessage(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

}
