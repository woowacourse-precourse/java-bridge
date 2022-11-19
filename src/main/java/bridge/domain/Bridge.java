package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    List<BridgeState> bridge;

    Bridge(List<String> bridge) {
        this.bridge = new ArrayList<>();
        makeBridge(bridge);
    }

    private void makeBridge(List<String> bridge) {
        for(String tile: bridge) {
            BridgeState state = BridgeState.makeBridgeState(tile);
            this.bridge.add(state);
        }
    }

    public boolean isSameTile(String givenTile, int stage) {
        BridgeState bridgeState = bridge.get(stage);
        return bridgeState.isSameState(givenTile);
    }
}
