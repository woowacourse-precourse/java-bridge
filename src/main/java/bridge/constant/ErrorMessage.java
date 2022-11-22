package bridge.constant;

public enum ErrorMessage {
    bridgeSizeError(String.format("다리 길이는 %d부터 %d 사이의 숫자여야 합니다.", Constant.MIN_LENGTH, Constant.MAX_LENGTH)),
    blockNameError("이동할 칸은 U 또는 D여야 합니다."),
    restartError("재시작 여부는 R 또는 Q여야 합니다.");

    private static final String errorPrefix = "[ERROR] ";

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorPrefix + this.errorMessage;
    }
}
