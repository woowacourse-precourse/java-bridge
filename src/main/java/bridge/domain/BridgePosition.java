package bridge.domain;

import java.util.Arrays;

public enum BridgePosition {
    UP("U", 1),
    DOWN("D", 0);

    private final String command;
    private final int value;

    BridgePosition(String command, int value) {
        this.command = command;
        this.value = value;
    }

    public static BridgePosition getPositionWithCommand(String command) {
        return Arrays.stream(BridgePosition.values())
                .filter(position -> position.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(""));
    }
}
