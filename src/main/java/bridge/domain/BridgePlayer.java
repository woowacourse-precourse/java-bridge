package bridge.domain;

import java.util.List;

public class BridgePlayer {

    private final List<BridgeMoveType> playerBridge;

    public BridgePlayer(List<BridgeMoveType> playerBridge) {
        this.playerBridge = playerBridge;
    }

    public void moveTo(BridgeMoveType moveType) {
        playerBridge.add(moveType);
    }
}
