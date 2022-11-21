package bridge.domain;

import bridge.system.ExceptionMessage;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        validate(bridge);
        this.bridge = bridge;
    }

    public void addBlock(String moving) {
        bridge.add(moving);
        validate(this.bridge);
    }

    public void reset() {
        bridge.clear();
    }

    public int length() {
        return bridge.size();
    }

    public boolean isPartOfBridge(Bridge otherBridge) {
        return otherBridge.containsAll(bridge);
    }

    public boolean containsAll(List<String> other) {
        List<String> temp = bridge.subList(0, other.size());
        return temp.equals(other);
    }

    @Override
    public String toString() {
        return bridge.toString();
    }

    private void validate(List<String> target) {
        int invalidCount = (int) target.stream()
                .filter(block -> !block.equals(GameMoving.UP.toString()))
                .filter(block -> !block.equals(GameMoving.DOWN.toString()))
                .count();
        if (invalidCount != 0) {
            throw new IllegalArgumentException(ExceptionMessage.BRIDGE_ELEMENT_INVALID);
        }
    }
}
