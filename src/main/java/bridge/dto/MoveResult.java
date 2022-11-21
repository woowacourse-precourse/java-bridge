package bridge.dto;

public class MoveResult {

    private final String message;
    private final boolean success;
    private final int round;

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getRound() {
        return round;
    }

    public MoveResult(String message, boolean success, int round) {
        this.message = message;
        this.success = success;
        this.round = round;
    }
}
