package bridge.view;

public enum Error {
    TAG ("[ERROR] "),
    ERROR_MAX_BRIDGE (TAG + "최대 20까지 입력할 수 있습니다."),
    ERROR_MIN_BRIDGE (TAG + "최소 3이상의 숫자를 적어주세요."),
    ERROR_NOT_NUMBER (TAG + "숫자가 아닙니다. 다시 입력하세요."),
    ERROR_NOT_COMMAD (TAG + "올바른 커맨드를 입력하세요.");


    private final String message;

    public String getMessage() {
        return message;
    }

    Error(String s) {
        this.message = s;
    }
}
