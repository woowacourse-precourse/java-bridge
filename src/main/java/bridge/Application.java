package bridge;


import java.util.List;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        runBridgeGame(bridgeGame);
    }

    private static void runBridgeGame(BridgeGame bridgeGame) {
        List<String> bridge = bridgeGame.makeBridge();
        BridgeResult result = bridgeGame.makeBridgeResult();
        boolean ready = true;
        while (ready) {
            ready = crossBridge(bridgeGame, bridge, result);
        }
        bridgeGame.exit();
    }

    private static boolean crossBridge(BridgeGame bridgeGame, List<String> bridge, BridgeResult result) {
        bridgeGame.retry(result);
        boolean block = false;
        while (!block) {
            block = bridgeGame.move(bridge, result);
        }
        return bridgeGame.endCycle(result);
    }
}
