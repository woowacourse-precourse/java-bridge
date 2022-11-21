package bridge.status;

public enum ExceptionStatus {
    INVALID_BOUNDARY("[ERROR] 유효범위의 숫자가 아닙니다. 다시 입력해 주세요."),
    INVALID_INPUT("[ERROR] 유효하지 않은 값입니다. 다시 입력해 주세요."),
    IS_NOT_NUMBER("[ERROR] 숫자가 아닙니다. 다시 입력해 주세요.");

    private String exception;

    ExceptionStatus(String exception) {
        this.exception = exception;
    }

    public String getException() {
        return  exception ;
    }
}
