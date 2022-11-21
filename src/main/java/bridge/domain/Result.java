package bridge.domain;

public class Result {
    private final boolean success;
    private final Bridge selectedBridge;
    private int failIndex;

    private Result(boolean success, Bridge selectedBridge, int failIndex) {
        this.success = success;
        this.selectedBridge = selectedBridge;
        this.failIndex = failIndex;
    }

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

    public int getFailIndex() {
        return failIndex;
    }

    public static Result fail(Bridge selectedBridge, int failIndex) {
        return new Result(false, selectedBridge, failIndex);
    }

    public static Result success(Bridge selectedBridge) {
        return new Result(true, selectedBridge);
    }
}
