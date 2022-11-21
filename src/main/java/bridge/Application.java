package bridge;

public class Application {

    public static void main(String[] args) {
        BridgeUtils bridgeUtils = new BridgeUtils();
        Bridge bridge = bridgeUtils.startBridgeGame();
        while (!bridge.isGameOver()){
            bridgeUtils.actWhenMoving(bridge);
        }
        if (bridge.isO(bridge.getMovings().size() - 1)) {

        }
        if (!bridge.isO(bridge.getMovings().size() - 1)) {

        }
    }
}
