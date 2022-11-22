package bridge.combinator;

public class BridgeCombinator {

    private static StringBuilder upSideBridge;
    private static StringBuilder downSideBridge;

    public void bridgeInit() {
        upSideBridge = new StringBuilder("[  ]");
        downSideBridge = new StringBuilder("[  ]");
    }

    public void drawBridge(BridgeCase bridgeCase) {
        bridgeCase.add(upSideBridge, downSideBridge);
    }

    public String combineBridge() {
        return upSideBridge.toString() + "\n" + downSideBridge.toString();
    }
}
