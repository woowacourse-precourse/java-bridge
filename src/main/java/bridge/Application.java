package bridge;

public class Application {

    public static void main(String[] args) {
        BridgeUtils bridgeUtils = new BridgeUtils();
        Bridge bridge = bridgeUtils.startBridgeGame();
        bridgeUtils.play(bridge);
    }
}
