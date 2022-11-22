package bridge.inputErrorHandle;

public enum InputException {
    NUMBER_RANGE_EXCEPTION("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    NUMBER_FORMAT_EXCEPTION("[ERROR] 숫자 형식에 오류가 있습니다."),

    COMMAND_LENGTH_EXCEPTION("[ERROR] 커맨드 길이는 1이어야 합니다."),
    COMMAND_RANGE_EXCEPTION("[ERROR] 커맨드는 R 아니면 Q여야 합니다."),

    DIRECTION_LENGTH_EXCEPTION("[ERROR] 방향의 길이는 1이어야 합니다."),
    DIRECTION_RANGE_EXCEPTION("[ERROR] 방향은 U 아니면 D여야 합니다.");



    private String message;

    InputException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
