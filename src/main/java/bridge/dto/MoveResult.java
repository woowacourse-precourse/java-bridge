package bridge.dto;

public class MoveResult {

    private final String message;
    private final boolean success;

    public MoveResult(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }
}
