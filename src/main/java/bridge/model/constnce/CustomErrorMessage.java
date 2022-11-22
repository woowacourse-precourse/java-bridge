package bridge.model.constnce;

public enum CustomErrorMessage {
    IS_NOT_UPPERCASE("[ERROR] 대문자만 입력 가능합니다."),
    INCORRECT_KEY_INPUT("[ERROR] U와 D만 입력이 가능합니다."),
    INCORRECT_COMMAND_INPUT("[ERROR] R과 Q만 입력이 가능합니다."),
    OUT_OF_RANGE("[ERROR] 3이상 20이하의 값만 입력하실 수 있습니다."),
    INCORRECT_FORMAT("자연수만 입력해주세요.")
    ;

    private final String message;

    CustomErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR + message;
    }

    public static final String ERROR = "[ERROR] : ";
}