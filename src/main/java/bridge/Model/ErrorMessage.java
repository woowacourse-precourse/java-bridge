package bridge.Model;

public enum ErrorMessage {
    ERROR_HEADER("[ERROR]"),
    INPUT_SIZE_ERROR(ERROR_HEADER.getMessage() + " 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INPUT_DIGIT_ERROR(ERROR_HEADER.getMessage() + " 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INPUT_MOVING_ERROR(ERROR_HEADER.getMessage() + " U(위)또는 D(아래)만 입력 가능합니다."),
    INPUT_COMMAND_ERROR(ERROR_HEADER.getMessage() + " R(재시작) 또는 Q(종료)만 입력 가능합니다."),
    BRIDGE_CONTENT_ERROR(ERROR_HEADER.getMessage() + " 다리에 잘못된 값이 포함되어 있습니다. 다리는 U 또는 D로만 표현 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
