package bridge.error;

public enum Error {
    SYSTEM_ERROR("내부 오류 입니다. 시스템을 재시작 해주세요"),
    BRIDGE_SIZE_RANGE_ERROR("다리 길이는 3 ~ 20 사이로 입력해 주세요."),
    BRIDGE_SIZE_TYPE_ERROR("다리 길이는 숫자로 입력해 주세요."),
    DIRECTION_INPUT_ERROR("이동할 칸은 [U], [D] 한 글자자로 입력해 주세요"),
    MAX_TRY_ERROR("최대 시도 횟수를 초과했습니다."),
    RETRY_INPUT_ERROR("재시도는 R, 종료는 Q로 입력해주세요.");

    private final String message;
    private static final String ERROR_PREFIX = "[ERROR] ";

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
