package bridge.domain;

import bridge.domain.utils.BridgeState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private List<BridgeState> bridgeGames;

    public User() {
        bridgeGames = new ArrayList<>();
    }

    public List<BridgeState> getBridgeGames() {
        return Collections.unmodifiableList(bridgeGames);
    }

    public void addUserState(BridgeState bridgeState) {
        bridgeGames.add(bridgeState);
    }

    public int crossingBridgeNumber() {
        return bridgeGames.size();
    }
}
