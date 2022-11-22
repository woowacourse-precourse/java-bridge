package bridge.validation;

public enum ErrorMessage {
    MOVE_AVAILABLE_BUT_NOT_MOVED("이동 가능한 칸이지만 이동하지 않았습니다."),
    MOVED_WHEN_UNAVAILABLE("이동할 수 없는 칸으로 이동했습니다."),
    LOWER_BRIDGE_IF_RANDOM_VALUE_ZERO("랜덤값이 0일 경우, 다리에 아래 칸이 추가되어야 합니다."),
    UPPER_BRIDGE_IF_RANDOM_VALUE_ONE("랜덤값이 1일 경우, 다리에 위 칸이 추가되어야 합니다."),
    INPUT_BRIDGE_SIZE_IN_INTEGER("다리의 길이를 숫자로 입력해주세요."),
    BRIDGE_SIZE_BETWEEN_THREE_AND_TWENTY("다리의 길이는 3이상, 20이하여야 합니다."),
    INPUT_COMMAND_IN_R_OR_Q("재시도, 종료 여부를 R 또는 Q로 입력해주세요."),
    INPUT_COMMAND_IN_D_OR_U("이동할 칸을 D 또는 U로 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        String prefix = "[ERROR] ";
        this.message = prefix + message;
    }

    public String getMessage() {
        return message;
    }
}
