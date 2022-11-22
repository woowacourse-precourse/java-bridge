package bridge.view;

public enum Success {
    SUCCESS("성공"), FAIL("실패");

    private final String message;

    Success(String message) {
        this.message = message;
    }

    public static String getMessage(boolean isSuccess) {
        if (isSuccess) {
            return SUCCESS.message;
        }
        return FAIL.message;
    }
}
