package bridge;

public class Application {

    public static void main(String[] args) {
        int size = 3;
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(size));
        BridgeGame bridgeGame = new BridgeGame(bridge);
    }
}
