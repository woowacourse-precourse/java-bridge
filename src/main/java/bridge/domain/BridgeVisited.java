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
    public String printMoveInfo() {
        return moveInfo.MapInfo();
    }

    public boolean isRemained(final Bridge bridge) {
        if (isEnd(bridge)) {
            return false;
        }
        return isAllStepCorrect(bridge);
    }

    private boolean isEnd(final Bridge bridge) {
        return positions.size() == bridge.getSize();
    }

    private boolean isAllStepCorrect(final Bridge bridge) {
        final int bound = positions.size();

        for (int index = 0; index < bound; index++) {
            if (!bridge.isEqual(index, positions.get(index))) {
                return false;
            }
        }
        return true;
    }
}
