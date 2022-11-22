package bridge.utils.constants;

public enum ErrorMessages {

    INVALID_INPUT_BRIDGE_SIZE("다리의 크기는 3이상, 20이하의 자연수만 입력 가능합니다."),
    INVALID_INPUT_BRIDGE_TYPE("다리의 크기는 숫자만 입력 가능합니다."),
    INVALID_INPUT_MOVE("이동할 칸은 U 또는 D만 입력 가능합니다."),
    INVALID_BRIDGE("다리는 \"U\"또는 \"D\"만 가능합니다."),
    INVALID_BRIDGE_SIZE("다리의 크기는 3이상 20이하 이어야 합니다."),
    INVALID_INPUT_COMMAND("게임 재시작/종료 입력은 R 또는 Q만 입력 가능합니다.");

    private final String message;
    private static final String ERROR = "[ERROR] ";

    ErrorMessages(final String message) {
        this.message = ERROR + message;
    }

    public String getMessage() {
        return message;
    }
}
