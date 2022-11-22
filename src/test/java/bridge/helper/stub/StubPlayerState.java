package bridge.helper.stub;

import bridge.domain.game.Bridge;
import bridge.domain.game.BridgeTile;
import bridge.domain.player.PlayerState;
import bridge.utils.common.BridgeConst;
import java.util.List;

public class StubPlayerState extends PlayerState {

    private final int stubPosition;

    public StubPlayerState(int stubPosition) {
        this.stubPosition = stubPosition;
    }

    @Override
    public BridgeTile findPlayerPositionTile(final List<BridgeTile> bridgeTiles) {
        return bridgeTiles.get(stubPosition);
    }

    @Override
    public boolean isSuccessful(Bridge bridge) {
        if (stubPosition < BridgeConst.MIN_BRIDGE_SIZE) {
            return false;
        }
        return bridge.isEndOfBridge(stubPosition);
    }
}
