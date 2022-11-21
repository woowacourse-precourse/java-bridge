package bridge.vo;

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

    public static String getCommandByValue(int value) {
        return Arrays.stream(BridgePosition.values())
                .filter(position -> position.value == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(""))
                .command;
    }

    public static BridgePosition getPositionByCommand(String command) {
        return Arrays.stream(BridgePosition.values())
                .filter(position -> position.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(""));
    }
}
