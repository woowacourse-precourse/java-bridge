package bridge.domain;

import bridge.domain.utils.BridgeState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private List<BridgeState> bridgeGames;
    private int retryCount;

    public User() {
        retryCount = 1;
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

    public BridgeState getUserCrossing(int index) {
        return bridgeGames.get(index);
    }

    public void initialize() {
        bridgeGames.clear();
        retryCount++;
    }
}
