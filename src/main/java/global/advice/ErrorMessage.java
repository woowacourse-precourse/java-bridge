package global.advice;

public enum ErrorMessage {
    COMMON("[ERROR] "),
    CHECK_SIZE("3 ~ 20 사이의 숫자를 입력 해 주세요 | "),
    CHECK_SIZE_DIGIT("숫자 이외의 값를 입력하셨습니다. | "),
    CHECK_MOVING("윗 칸: U / 아래 칸: D 입니다. 올바른 입력을 해 주세요 | "),
    CHECK_RETRY("재시작: R / 종료: Q 입니다. 올바른 입력을 해 주세요 | "),
    CHECK_OUTBOUND("비교할 수 없는 값의 범위 입니다. "),
    CAUSE("원인: "),
    INPUT("입력: "),
    COMPARE("비교값: ");


    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static String makeErrorMessage(ErrorMessage errorMessage) {
        return COMMON.errorMessage + errorMessage.errorMessage + INPUT.errorMessage;
    }

    public static String makeErrorMessage(String cause, String input) {
        return CAUSE.errorMessage + cause + INPUT.errorMessage + input;
    }

    public static String makeErrorMessage(int cause, String input) {
        return CAUSE.errorMessage + cause + COMPARE.errorMessage + input;
    }
}
