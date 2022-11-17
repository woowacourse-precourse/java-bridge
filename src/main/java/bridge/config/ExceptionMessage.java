package bridge.config;

public enum ExceptionMessage {
    WRONG_ELEMENT("다리의 요소는 반드시 U, D이어야 합니다."),
    NOT_NUMBER_SIZE("다리의 길이는 오직 숫자만 입력받아야 합니다."),
    NUMBER_OUT_OF_RANGE("다리의 길이는 3 ~ 20이어야 합니다."),
    NOT_ALL_UPPERCASE("오직 대문자만 입력 받을 수 있습니다."),
    WRONG_OPTION_LENGTH("1글자만 입력해야 합니다.");

    private final String message;

    public static final String ERROR = "[ERROR]";

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ERROR + message;
    }
}
