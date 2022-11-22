package bridge.utils;

public enum Error {
    NOT_A_NUMBER("[ERROR] 숫자 외의 문자가 포함되어있습니다."),
    NOT_IN_RANGE("[ERROR] 3 이상 20 이하의 숫자만 입력할 수 있습니다."),
    NOT_U_OR_D("[ERROR]U와 D 중 하나의 문자를 입력해주세요."),
    NOT_R_OR_Q("[ERROR]R과 Q 중 하나의 문자를 입력해주세요.");

    private String errorMessage;

    Error(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return this.errorMessage;
    }

}
