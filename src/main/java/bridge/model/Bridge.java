package bridge.model;

import java.util.List;

public class Bridge {
    private static final int MAX_BRIDGE_SIZE = 20;
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final String BRIDGE_SIZE_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다";
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        validateBridgeSize(bridge.size());
        this.bridge = bridge;
    }

    private void validateBridgeSize(int size) {
        if (size < MIN_BRIDGE_SIZE || size > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR);
        }
    }

    public Movable compareSpace(int position, String selectedSpace) {
        String space = bridge.get(position);
        if (space.equals(selectedSpace)) {
            return Movable.O;
        }
        return Movable.X;
    }

    public boolean isEndOfBridge(int position) {
        return position == bridge.size();
    }
}