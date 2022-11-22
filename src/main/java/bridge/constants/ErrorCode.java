package bridge.constants;

public enum ErrorCode {
    ERROR_ULL_OR_EMPTY("값을 입력해주세요."),
    ERROR_NOT_NUMBER("숫자를 입력해주세요."),
    ERROR_INVALID_BRIDGE_SIZE("3이상 20 이하의 숫자를 입력해주세요."),
    ERROR_NO_BRIDGE_MATCHING_NUMBER("숫자에 해당하는 다리가 없습니다."),
    ERROR_INVALID_BRIDGE_TO_MOVE("이동할 칸이 올바르지 않습니다. (위: U, 아래: D)"),
    ERROR_INVALID_COMMAND("명령이 올바르지 않습니다. (재시도: R, 종료: Q)");

    private static final String ERROR_BEGIN = "[ERROR] ";
    private final String errorMessage;

    ErrorCode(String errorMessage) {
        this.errorMessage = ERROR_BEGIN + errorMessage;
    }

    public IllegalArgumentException throwIllegalArgumentException() {
        throw new IllegalArgumentException(this.getErrorMessage());
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
