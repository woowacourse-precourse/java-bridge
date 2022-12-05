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

    public boolean isPartOfBridgeInOrder(Bridge otherBridge) {
        return otherBridge.containsAllInOrder(bridge);
    }

    public boolean containsAllInOrder(List<String> other) {
        List<String> temp = bridge.subList(0, other.size());
        return temp.equals(other);
    }

    @Override
    public String toString() {
        return bridge.toString();
    }

    private void validate(List<String> target) {
        boolean isValidBridge = target.stream()
                .allMatch(block -> block.equals(GameMoving.UP.toString()) ||
                        block.equals(GameMoving.DOWN.toString()));

        if (!isValidBridge) {
            throw new IllegalArgumentException(ExceptionMessage.BRIDGE_ELEMENT_INVALID);
        }
    }
}
