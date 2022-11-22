package bridge.drawer;

import java.util.Arrays;

public class BridgeDrawer {

    private static StringBuilder upSideBridge;
    private static StringBuilder downSideBridge;

    public void bridgeInit() {
        upSideBridge = new StringBuilder("[  ]");
        downSideBridge = new StringBuilder("[  ]");
    }

    public void drawBridge(BridgeCase bridgeCase, boolean isAnswer) {
        bridgeCase.add(upSideBridge, downSideBridge,
                Arrays.stream(BridgeState.values())
                        .filter(bridgeState -> isAnswer == bridgeState.isState())
                        .findFirst().orElse(BridgeState.NOTHING).getShape());
    }

    public String combineBridge() {
        return upSideBridge.toString() + "\n" + downSideBridge.toString();
    }
}
