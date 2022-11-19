package bridge.model;

import java.util.Arrays;

import static bridge.exception.Errors.INVALID_PARAMETER;

public enum BridgePosition {
    BRIDGE_POSITION_UP("U", 1),
    BRIDGE_POSITION_DOWN("D", 0);

    private final String command;
    private final int position;

    BridgePosition(final String command, final int position) {
        this.command = command;
        this.position = position;
    }

    public String getCommand() {
        return command;
    }

    public static String from(final int position) {
        BridgePosition bridge = Arrays.stream(values())
                .filter(bridgePosition -> bridgePosition.isSamePosition(position))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(INVALID_PARAMETER.getMessage()));

        return bridge.getCommand();
    }

    private boolean isSamePosition(final int position) {
        return this.position == position;
    }
}
