package bridge.utils.message;

public enum ErrorMessagesUtil {
    PREFIX("[ERROR] "),
    ONLY_NUMBERS("숫자를 입력해주세요. 음수도 허용하지 않습니다."),
    SIZE_OUT_OF_RANGE("다리의 길이는 3 ~ 20으로만 입력할 수 있습니다."),
    MOVING("이동은 'U' 또는 'D'로만 가능합니다."),
    RETRY_COMMAND("재시작은 'R' 그만두려면 'Q'를 입력해주세요.");

    final String message;

    ErrorMessagesUtil(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX.message + this.message;
    }
}
