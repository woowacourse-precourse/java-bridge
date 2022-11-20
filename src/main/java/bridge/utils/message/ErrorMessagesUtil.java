package bridge.utils.message;

public enum ErrorMessagesUtil {
    PREFIX("[ERROR] "),
    NOT_BLANK("공백을 입력할 수 없습니다."),
    ONLY_NUMBERS("숫자를 입력해주세요. 음수도 허용하지 않습니다."),
    SIZE_OUT_OF_RANGE("다리의 길이는 3 ~ 20으로만 입력할 수 있습니다."),
    MOVING("이동은 'U' 또는 'D'로만 가능합니다.");


    final String message;

    ErrorMessagesUtil(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX.message + this.message;
    }
}
