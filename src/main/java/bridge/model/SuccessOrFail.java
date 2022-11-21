package bridge.model;

import bridge.util.Constant;
import bridge.util.Message;

import java.util.Arrays;

public enum SuccessOrFail {
    SUCCESS(Message.SUCCESS_MESSAGE, true),
    FAIL(Message.FAIL_MESSAGE, false);

    private final String message;
    private final boolean complete;

    SuccessOrFail(String message, boolean complete) {
        this.message = message;
        this.complete = complete;
    }

    public static String getSuccessOrFailMessage(boolean complete) {
        return Arrays.stream(SuccessOrFail.values())
                .filter(successOrFail -> successOrFail.complete == complete)
                .findAny()
                .orElseThrow().message;
    }
}
