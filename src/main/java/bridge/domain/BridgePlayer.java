package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgePlayer {

    private final List<BridgeMoveType> playerBridge;

    public BridgePlayer() {
        this.playerBridge = new ArrayList<>();
    }

    public boolean isLastMoveTypeNotSameAs(List<BridgeMoveType> bridgeMoveTypes) {
        int currentLocation = playerBridge.size() - 1;
        return playerBridge.get(currentLocation) != bridgeMoveTypes.get(currentLocation);
    }

    public void moveTo(BridgeMoveType moveType) {
        playerBridge.add(moveType);
    }

    public void clearPlayerBridge() {
        playerBridge.clear();
    }

    public List<BridgeMoveType> getMoveHistory() {
        return new ArrayList<>(playerBridge);
    }
}
