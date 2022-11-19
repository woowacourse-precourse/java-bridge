package bridge.domain;

import java.util.List;
import java.util.Objects;

public class Bridge {
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
        if (randomBridge.size() < 3 || randomBridge.size() > 20) {
            throw new IllegalArgumentException(" 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
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
