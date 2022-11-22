package bridge.data.constant;

public enum ErrorMessage {
    BRIDGE_SIZE_ERROR("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    MOVING_INPUT_ERROR("U 또는 D를 입력해야 합니다."),
    COMMAND_INPUT_ERROR("R 또는 Q를 입력해야 합니다.");

    private final String errorLog;

    public String getErrorLog() {
        return "[ERROR] " + this.errorLog;
    }

    ErrorMessage(String errorLog) {
        this.errorLog = errorLog;
    }

}
