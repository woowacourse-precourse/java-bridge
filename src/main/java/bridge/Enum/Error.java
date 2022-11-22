package bridge.Enum;

public enum Error {
    BRIDGE_SIZE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INPUT_BLANK("입력은 빈칸이어서는 안됩니다."),
    INPUT_DIRECTION("이동할 수 있는 칸은 U나 D만 입력 가능합니다."),
    INPUT_CONTINUE("게임 재시작 여부는 R이나 Q만 입력 가능합니다.");
    ;

    private static final String ERROR = "[ERROR] ";

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR + message;
    }
}
