package bridge.view;

public enum Success {
    SUCCESS(true, "성공"), FAIL(false, "실패");

    private final boolean isSuccess;
    private final String message;

    Success(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public static String getMessage(boolean isSuccess) {
        if (isSuccess) {
            return SUCCESS.message;
        }
        return FAIL.message;
    }
}
