package bridge.exception;

public enum InputError {
    NOT_A_NUMBER("숫자를 입력해야 합니다."),
    INVALID_NUMBER_RANGE("3 이상 20 이하의 숫자를 입력해야 합니다."),
    INVALID_MOVING_INPUT("U 또는 D만 입력해야 합니다."),
    INVALID_MOVING_LENGTH("한 칸만 이동할 수 있습니다."),;

    private final String message;

    InputError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    }
