package bridge.type;

public enum ErrorType {
    ERROR_HEADER("[ERROR] "),
    BRIDGE_SIZE_ERROR("3이상 20 이하 숫자를 입력해 주세요."),
    DIGIT_ERROR("숫자를 입력해주세요."),
    MOVING_ERROR("U 혹은 D를 입력해 주세요."),
    COMMAND_ERROR("R 혹은 Q를 입력해 주세요.");

    private final String error;

    ErrorType(String error) {
        this.error = error;
    }

    public String printError() {
        return ERROR_HEADER.error + error;
    }
}
