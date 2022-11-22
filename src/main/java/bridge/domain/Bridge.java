package bridge.domain;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.util.Lists;

public class Bridge {
    private final List<BridgeState> bridge;

    public Bridge(List<String> bridge) {
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

    public boolean isLastTile(int stage) {
        if(bridge.size() == stage) {
            return true;
        }
        return false;
    }

    public List<BridgeState> makeSubBridge(int stage) {
        List<BridgeState> subBridge = Lists.newArrayList(bridge);
        return subBridge.subList(0, stage+1);
    }
}
