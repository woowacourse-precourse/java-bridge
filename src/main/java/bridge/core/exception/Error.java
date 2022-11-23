package bridge.core.exception;

public enum Error {

    NON_NUMERIC_ERROR("NON_NUMERIC_ERROR", "[ERROR] 숫자만 입력 가능합니다."),
    OUT_OF_RANGE_ERROR("OUT_OF_RANGE_ERROR", "[ERROR] 3 이상 20 이하의 숫자만 입력 가능합니다."),
    SELECT_BLOCK_ERROR("SELECT_BLOCK_ERROR", "[ERROR] U와 D만 입력 가능합니다."),
    GAME_COMMAND_ERROR("GAME_COMMAND_ERROR", "[ERROR] R과 Q만 입력 가능합니다."),
    FAIL("FAIL", "[ERROR] %1(이)가 실패하였습니다.");

    private String errorCode;
    private String message;

    Error(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getCode() {
        return this.errorCode;
    }

    public String getMessage(String... args) {
        return ErrorMessageUtil.parseMessage(this.message, args);
    }
}
