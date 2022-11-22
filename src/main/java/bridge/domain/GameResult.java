package bridge.domain;

public class GameResult {
    private final boolean success;
    private final Bridge selectedBridge;

    private GameResult(boolean success, Bridge selectedBridge) {
        this.success = success;
        this.selectedBridge = selectedBridge;
    }

    public boolean isSuccess() {
        return success;
    }

    public Bridge getSelectedBridge() {
        return selectedBridge;
    }


    public static GameResult fail(Bridge selectedBridge) {
        return new GameResult(false, selectedBridge);
    }

    public static GameResult success(Bridge selectedBridge) {
        return new GameResult(true, selectedBridge);
    }
}
