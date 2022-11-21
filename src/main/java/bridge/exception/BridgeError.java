package bridge.exception;

public enum BridgeError {

    BRIDGE_FORM("[ERROR] 다리 길이는 숫자만 입력 가능합니다."),
    BRIDGE_LENGTH("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    MOVE_FORM("[ERROR] 이동할 칸은 U와 D 문자만 입력 가능합니다."),
    MOVE_SIZE("[ERROR] 이동할 칸은 하나만 입력 가능합니다."),
    COMMAND_FORM("[ERROR] 재시작 여부 명령어는 R와 Q 문자만 입력 가능합니다."),
    COMMAND_SIZE("[ERROR] 재시작 여부 명령어는 하나만  입력 가능합니다.");

    private final String message;

    BridgeError(final String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
