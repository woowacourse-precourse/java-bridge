package bridge.constants;

public enum ErrorConstant {
    SIZE_EXCEPTION("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    NUMBER_ERROR ("숫자를 입력해주세요."),
    RANGE_ERROR ("다리 길이는 3~20 사이의 숫자를 입력해주세요."),
    UPDOWN_ERROR ("U와 D 중 입력해주세요."),
    RETRY_ERROR ("R과 Q 중 입력해주세요.");
    private String exception;

    ErrorConstant(String exception) {
        this.exception = exception;
    }

    public String getException() {
        return exception;
    }
    public void printException(){
        System.out.println(this.exception);
    }
}
