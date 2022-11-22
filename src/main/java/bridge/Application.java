package bridge;

import bridge.domain.BridgeGameExecutor;

public class Application {

    public static void main(String[] args) {
        BridgeGameExecutor bridgeGameExecutor = BridgeGameExecutor.getInstance();
        bridgeGameExecutor.start();
    }
}
