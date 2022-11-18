package bridge.constant;

public enum ErrorMessage {

    IS_NOT_POSITIVE_NUMBER("[ERROR] 다리 길이 입력값이 양의 정수가 아닙니다."),
    IS_OUT_OF_RANGE("[ERROR] 다리 길이 입력값이 범위 3 ~ 20을 벗어났습니다."),
    IS_WRONG_MOVEMENT("[ERROR] 움직임 입력이 U 혹은 D 가 아닙니다."),
    IS_WRONG_RETRY_STATUS("[ERROR] 재시도 입력이 R 혹은 Q 가 아닙니다."),
    INPUT_AGAIN("올바른 형식으로 재입력하시기 바랍니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
