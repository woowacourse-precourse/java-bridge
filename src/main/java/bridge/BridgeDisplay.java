package bridge;

import java.util.Arrays;

public enum BridgeDisplay {
    O(true),
    X(false);

    private boolean bool;

    BridgeDisplay(boolean bool) {
        this.bool = bool;
    }

    public boolean isBool() {
        return bool;
    }

    public static String toString(boolean bool) {
        return Arrays.stream(BridgeDisplay.values())
                .filter(display -> display.isBool() == bool)
                .findAny()
                .get().name();
    }
}
