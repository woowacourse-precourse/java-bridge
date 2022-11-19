package bridge;

import java.util.List;

public class Bridge {
    private final List<String> bridges;

    public Bridge(List<String> bridge) {
        this.bridges = bridge;
    }

    public MoveResult moveResult(int round, String controlKey) {
        return new MoveResult(controlKey, bridges.get(round).matches(controlKey));
    }

    public int bridgeSize() {
        return bridges.size();
    }

}
