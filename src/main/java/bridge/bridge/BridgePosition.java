package bridge.bridge;

import static bridge.exception.IllegalArgumentExceptionMessage.ILLEGAL_BRIDGE_POSITION;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum BridgePosition {
    BRIDGE_UP("U"), BRIDGE_DOWN("D");

    private static final Map<String, BridgePosition> mapper = new HashMap<>();

    static {
        Arrays.stream(BridgePosition.values())
                .forEach(bridgePosition -> mapper.put(bridgePosition.getPosition(), bridgePosition));
    }

    private final String position;

    BridgePosition(String position) {
        this.position = position;
    }

    public static BridgePosition fromString(String position) throws IllegalArgumentException {
        if (!mapper.containsKey(position)) {
            throw new IllegalArgumentException(ILLEGAL_BRIDGE_POSITION.getMessage());
        }
        return mapper.get(position);
    }

    public String getPosition() {
        return position;
    }
}
