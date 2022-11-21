package bridge.constant;

public enum ErrorMessage {
    SIZE_TYPE("[ERROR] 다리 길이는 숫자이어야 합니다."),
    SIZE_RANGE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    SPACE_TYPE("[ERROR] 이동할 칸은 U, D 중 하나만 입력 가능합니다."),
    COMMAND_TYPE("[ERROR] 재시도, 종료 여부는 R, Q 중 하나만 입력 가능합니다.");

    private final String message;

    private ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
