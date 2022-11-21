package bridge.exception;

import static bridge.view.OutputView.ERROR_PREFIX;

public enum ExceptionType {

    BRIDGE_SIZE_OUT_OF_RANGE(ERROR_PREFIX, "3 ~ 20 사이의 자연수를 입력해주세요."),
    ;

    private final String type;
    private final String message;

    ExceptionType(final String type, final String message) {
        this.type = type;
        this.message = message;
    }

    public String getMessage() {
        return type + " " + message;
    }
}
