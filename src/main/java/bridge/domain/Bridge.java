package bridge.domain;

import java.util.List;

public class Bridge {
    private static final int MINIMUM_SIZE = 3;
    private static final int MAXIMUM_SIZE = 20;

    private final List<String> bridges;

    public Bridge(List<String> bridges) {
        validateSize(bridges);
        this.bridges = bridges;
    }

    public boolean isFinish(int distance) {
        return bridges.size() == distance;
    }

    public MoveResult crossBridge(int distance, Move moveTo) {
        Move destination = Move.from(bridges.get(distance));

        return MoveResult.decide(destination, moveTo);
    }

    private void validateSize(List<String> bridges) {
        if (bridges.size() < MINIMUM_SIZE || bridges.size() > MAXIMUM_SIZE) {
            throw new IllegalArgumentException(GameException.INVALID_BRIDGE_SIZE.name());
        }
    }

    @Override
    public String toString() {
        return bridges.toString();
    }
}
