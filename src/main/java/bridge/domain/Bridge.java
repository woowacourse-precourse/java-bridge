package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridges;

    public Bridge(List<String> bridges) {
        this.bridges = bridges;
    }

    public boolean isFinish(int distance) {
        return bridges.size() == distance;
    }

    public MoveResult crossBridge(int distance, Move moveTo) {
        return MoveResult.move(Move.from(bridges.get(distance)), moveTo);
    }

    @Override
    public String toString() {
        return bridges.toString();
    }
}
