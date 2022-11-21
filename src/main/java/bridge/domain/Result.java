package bridge.domain;

public class Result {
    private final boolean success;
    private final Bridge selectedBridge;

    private Result(boolean success, Bridge selectedBridge) {
        this.success = success;
        this.selectedBridge = selectedBridge;
    }

    public boolean isSuccess() {
        return success;
    }

    public Bridge getSelectedBridge() {
        return selectedBridge;
    }


    public static Result fail(Bridge selectedBridge) {
        return new Result(false, selectedBridge);
    }

    public static Result success(Bridge selectedBridge) {
        return new Result(true, selectedBridge);
    }
}
