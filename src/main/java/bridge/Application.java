package bridge;

public class Application {

    public static void main(String[] args) {
        BridgeGameExecutor bridgeGameExecutor = BridgeGameExecutor.getInstance();
        bridgeGameExecutor.start();
    }
}
