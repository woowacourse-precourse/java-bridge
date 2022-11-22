package bridge;

public enum ValidateDetail {
    NUMERIC_PATTERN("^[0-9]*$"),
    UP_OR_DOWN_PATTERN("^[UD]*$"),
    RESTART_OR_QUIT_PATTERN("^[RQ]*$"),
    MAX_BRIDGE_SIZE("20"),
    MIN_BRIDGE_SIZE("3"),
    ERROR("[ERROR] "),
    RANGE_ERROR("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    MOVING_ERROR("이동할 칸은 U또는 D 중 하나의 문자여야 합니다."),
    COMMAND_ERROR("게임 재시작/종료 여부는 R또는 Q 중 하나의 문자여야합니다.");

    private final String message;

    ValidateDetail(String message) {
        this.message = message;
    }

    public String getPattern() {
        return message;
    }

    public String getErrorMassage() {
        return ERROR.message + message;
    }

    public Integer getSize() {
        return Integer.parseInt(message);
    }
}
