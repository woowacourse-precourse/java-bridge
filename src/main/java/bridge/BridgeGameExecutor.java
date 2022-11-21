package bridge;


public class BridgeGameExecutor {
    private static final BridgeGameExecutor instance = new BridgeGameExecutor();

    private BridgeGameExecutor() {
    }

    public static BridgeGameExecutor getInstance() {
        return instance;
    }
}
