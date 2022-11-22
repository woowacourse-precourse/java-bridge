package bridge.domain;

public enum ClearStatus {

    SUCCESS("성공", true),
    FAILURE("실패", false);

    private final String message;
    private final boolean clear;

    ClearStatus(String message, boolean clear) {
        this.message = message;
        this.clear = clear;
    }

    public static ClearStatus getMessageByClear(boolean clear) {
        if (SUCCESS.clear == clear) {
            return SUCCESS;
        }
        return FAILURE;
    }

    public String getMessage() {
        return message;
    }
}
