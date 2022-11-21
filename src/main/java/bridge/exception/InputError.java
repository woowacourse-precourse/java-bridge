package bridge.exception;

public enum InputError {
    NOT_A_NUMBER("숫자를 입력해야 합니다."),
    INVALID_NUMBER_RANGE("3 이상 20 이하의 숫자를 입력해야 합니다."),
    INVALID_MOVING("U 또는 D만 입력해야 합니다."),
    INVALID_INPUT_SIZE("한 글자만 입력해야 합니다."),
    INVALID_RESTART_OPTION("R 또는 Q만 입력해야 합니다.");

    private final String message;

    InputError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    }
