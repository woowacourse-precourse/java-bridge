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
        for(String square: bridge) {
            BridgeState state = BridgeState.makeBridgeState(square);
            this.bridge.add(state);
        }
    }
}
