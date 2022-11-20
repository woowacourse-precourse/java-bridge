package global.advice;

public enum ErrorMessage {
    COMMON("[ERROR] "),
    CHECK_SIZE("3 ~ 20 사이의 숫자를 입력 해 주세요 | 입력: "),
    CHECK_SIZE_DIGIT("문자 이외의 숫자를 입력하셨습니다. | 입력: "),
    CHECK_MOVING("윗 칸: U / 아래 칸: D 입니다. 올바른 입력을 해 주세요 | 입력: "),
    CHECK_RETRY("재시작: R / 종료: Q 입니다. 올바른 입력을 해 주세요 | 입력: ");


    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static String makeErrorMessage(ErrorMessage errorMessage) {
        return COMMON.errorMessage + errorMessage.errorMessage;
    }
}
