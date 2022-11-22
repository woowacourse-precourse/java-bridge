package bridge.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public int getBridgeSize() {
        return bridge.size();
    }

    public boolean isAllEqualSoFar(List<String> movement) {
        return IntStream.range(0, movement.size()).allMatch(index -> bridge.get(index).equals(movement.get(index)));
    }

    public boolean isEqual(List<String> playerChoices) {
        return playerChoices.equals(bridge);
    }
}
