package bridge.domain;

public class MoveResult {

    private String message;
    private boolean success;

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public MoveResult(String message, boolean correct) {
        this.message = message;
        this.success = correct;
    }

}
