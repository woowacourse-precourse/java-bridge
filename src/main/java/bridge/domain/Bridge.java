package bridge.domain;

import java.util.List;
import java.util.Objects;

public class Bridge {
    private static final int MINIMUM_LENGTH = 3;
    private static final int MAXIMUM_LENGTH = 20;
    private static final String BRIDGE_LENGTH_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private final List<String> bridge;

    public Bridge(List<String> randomBridge) {
        checkBridgeLength(randomBridge);
        bridge = randomBridge;
    }

    public boolean movable(String input, int index) {
        return bridge.get(index).equals(input);
    }

    public boolean isNotSize(int size) {
        return bridge.size() != size;
    }

    private void checkBridgeLength(List<String> randomBridge) {
        if (randomBridge.size() < MINIMUM_LENGTH || randomBridge.size() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException(BRIDGE_LENGTH_ERROR);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bridge bridge1 = (Bridge) o;
        return Objects.equals(bridge, bridge1.bridge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bridge);
    }
}
