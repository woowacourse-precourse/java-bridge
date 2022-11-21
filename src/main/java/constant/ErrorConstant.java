package constant;

public enum ErrorConstant {
    RETRY_OR_QUIT_INVALID("재시도는 R, 종료는 Q를 입력하세요."),
    MOVE_INVALID("이동할 칸은 위(U) 또는 아래(D)를 입력하세요."),
    INPUT_LENGTH("입력은 한글자만 가능합니다"),
    BRIDGE_SIZE_INVALID_RANGE("다리 길이는 3부터 20 사이의 숫자여야 합니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String errorConstant;

    ErrorConstant(final String errorConstant) {
        this.errorConstant = errorConstant;
    }

    public String getConstant() {
        return ERROR_PREFIX + errorConstant;
    }
}
