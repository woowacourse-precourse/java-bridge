package bridge.domain.bridge;

import java.util.Arrays;

public enum BridgeDirection {
    UP(1, "U"),
    DOWN(0, "D");

    private final int type;
    private final String initial;

    BridgeDirection(int type, String initial) {
        this.type = type;
        this.initial = initial;
    }

    public static BridgeDirection of(String initial) {
        return Arrays.stream(values())
                .filter(dir -> dir.initial.equals(initial))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static BridgeDirection of(int type) {
        return Arrays.stream(values())
                .filter(dir -> dir.type == type)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String getInitial() {
        return initial;
    }
}
