package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridges;

    public Bridge(List<String> bridges) {
        this.bridges = bridges;
    }

    public MoveResult crossBridge(int distance, String direction) {
        return MoveResult.move(bridges.get(distance), direction);
    }

    @Override
    public String toString() {
        return bridges.toString();
    }
}
