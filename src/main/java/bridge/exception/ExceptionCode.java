package bridge.exception;

public enum ExceptionCode {
    SIZE_ERROR("[ERROR] 다리의 길이는 3이상 20이하의 숫자입니다."),
    INPUT_ERROR("[ERROR] 입력값은 U나 D여야 합니다."),
    INPUT_TRY_ERROR("[ERROR] 재시작하려면 R 종료하려면 Q를 입력해야 합니다.");

    private final String message;

    ExceptionCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
