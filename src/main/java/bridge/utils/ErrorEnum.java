package bridge.utils;

public enum ErrorEnum {
    BRIDGE_SIZE_SMALLER_THAN_THREE("[ERROR] 다리 길이는 3이상의 숫자여야만 합니다."),
    BRIDGE_SIZE_BIGGER_THAN_TWENTY("[ERROR] 다리 길이는 20이하의 숫자여야만 합니다."),
    BRIDGE_SIZE_NOT_INT("[ERROR] 다리 길이는 숫자만 입력해야 합니다."),
    MOVE_NOT_U_OR_D("[ERROR] U나 D를 입력해야 합니다."),
    GAME_COMMAND_NOT_Q_OR_R("[ERROR] R이나 Q를 입력해야합니다.");

    private String message;

    ErrorEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
