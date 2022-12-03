package bridge.validator;

public enum ErrorStatus {
    BRIDGE_SIZE_TYPE_ERROR("다리 길이는 정수만 입력 가능합니다."),
    BRIDGE_SIZE_RANGE_ERROR("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    BRIDGE_SIZE_BLANK_ERROR("다리 길이는 공백으로 둘 수 없습니다."),
    DIRECTION_SIGN_ERROR("이동할 칸은 U 혹은 D 만 입력 가능합니다."),
    GAME_COMMAND_SIGN_ERROR("재시작 여부는 R 혹은 Q만 입력 가능합니다.");

    private final String message;

    ErrorStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + this.message;
    }
}
