package bridge.messages;

public enum ErrorMessage {
    PREFIX_ERROR_MESSAGE("[ERROR] "),
    INVALID_BRIDGE_SIZE(PREFIX_ERROR_MESSAGE.getMessage() + "다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INVALID_MOVE_DIRECTION(PREFIX_ERROR_MESSAGE.getMessage() + "올바른 칸을 선택해 주세요. (위: U, 아래: D)"),
    INVALID_RETRY_INPUT(PREFIX_ERROR_MESSAGE.getMessage() + "재시도는 R, 종료는 Q를 입력해 주세요");

    String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
