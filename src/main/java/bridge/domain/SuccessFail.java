package bridge.domain;

import bridge.constant.ErrorCode;

import java.util.Arrays;

public enum SuccessFail {
    SUCCESS(true, "성공"),
    FAIL(false, "실패");

    private boolean isSuccess;
    private String message;

    SuccessFail(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public static SuccessFail findSuccessFail(boolean isSuccess) {

        return Arrays.stream(SuccessFail.values())
                .filter(successFail -> successFail.isSuccess == isSuccess)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorCode.WRONG_INPUT.getMessage()));
    }

    public String getMessage() {
        return message;
    }
}
