package bridge.utils.constants;

public enum ErrorMessages {

    INVALID_BRIDGE_SIZE("다리의 크기는 3이상, 20이하의 자연수만 입력 가능합니다."),
    INVALID_BRIDGE_TYPE("다리의 크기는 숫자만 입력 가능합니다."),
    INVALID_MOVE("이동할 칸은 U 또는 D만 입력 가능합니다."),
    INVALID_COMMAND("게임 재시작/종료 입력은 R 또는 Q만 입력 가능합니다.")
    ;

    private final String message;
    private static final String error = "[ERROR] ";

    ErrorMessages(final String message) {
        this.message = error + message;
    }

    public String getMessage() {
        return message;
    }
}
