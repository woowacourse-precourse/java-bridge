package bridge.error;

public enum ErrorMessage {
    NOT_NUMBER_BRIDGE_SIZE("[ERROR] 다리 길이는 숫자여야 합니다."),
    INVALID_BRIDGE_SIZE("[ERROR] 다리 길이는 3 ~ 20 사이의 숫자여야 합니다."),
    NOT_ONE_STRING_MOVING("[ERROR] 이동할 칸은 한 문자여야 합니다."),
    NOT_UPPER_CASE_MOVING("[ERROR] 이동할 칸은 대문자여야 합니다."),
    U_OR_D_MOVING("[ERROR] 이동할 칸은 U 또는 D 여야 합니다."),
    NOT_ONE_STRING_COMMAND("[ERROR] 게임 재시작/종료 여부는 한 문자여야 합니다."),
    NOT_UPPER_CASE_COMMAND("[ERROR] 게임 재시작/종료 여부는 대문자여야 합니다."),
    R_OR_Q_COMMAND("[ERROR] 게임 재시작/종료 여부는 R 또는 Q여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
