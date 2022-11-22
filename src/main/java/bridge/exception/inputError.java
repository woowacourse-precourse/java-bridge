package bridge.exception;

public enum inputError {
    IS_NUMBER("[ERROR] 숫자를 입력해야 합니다."),
    NUMBER_RANGE("[ERROR] 3 이상 20 이하의 숫자를 입력해야 합니다."),
    INPUT_UP_DOWN("[ERROR] U 확은 D를 입력해야합니다."),
    RESTART("[ERROR] R혹은 Q를 입력해야합니다."),;

    private final String message;

    inputError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

