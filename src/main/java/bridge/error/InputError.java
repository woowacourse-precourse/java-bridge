package bridge.error;

public enum InputError implements Error {
    INVALID_SIZE("사이즈를 양의 정수로 입력해주세요."),
    INVALID_DIRECTION_SYMBOL("올바른 방향을 기호로 입력해주세요."),
    INVALID_COMMAND_SYMBOL("올바른 명령어를 기호로 입력해주세요."),
    ;

    InputError(String message) {
        this.message = message;
    }

    private final String message;

    @Override
    public String getMessage() {
        return message;
    }
}
