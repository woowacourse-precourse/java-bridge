package bridge.constants;

public enum ExceptionConstants {
    BRIDGE_SIZE_NOT_INTEGER("[ERROR] 다리 길이가 숫자가 아닙니다"),
    BRIDGE_SIZE_OUT_OF_RANGE("[ERROR] 다리 길이는 3이상 20이하여야 합니다."),
    MOVE_COMMAND_NOT_U_OR_D("[ERROR] 이동할 칸은 U나 D로 입력해야 합니다."),
    RETRY_COMMAND_NOT_R_OR_Q("[ERROR] 재시작/종료 여부는 R이나 Q로 입력해야 합니다.");
    private String message;

    ExceptionConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
