package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeVisited {
    private final List<BridgeGamePosition> positions = new ArrayList<>();
    private final BridgeGameMoveInfo moveInfo = new BridgeGameMoveInfo();

    public void move(final BridgeGamePosition move, final Bridge bridge) {
        moveInfo.moveInfo(move, bridge.isEqual(positions.size(), move));
        positions.add(move);
    }
}
