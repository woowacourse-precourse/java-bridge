package bridge.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static bridge.exception.Errors.INVALID_PARAMETER;

public enum BridgePosition {
    BRIDGE_POSITION_UP("U", 1),
    BRIDGE_POSITION_DOWN("D", 0);

    public static final String RIGHT_SIGN = "O";
    public static final String WRONG_SIGN = "X";
    public static final String BLANK_SIGN = " ";

    private final String command;
    private final int position;

    BridgePosition(final String command, final int position) {
        this.command = command;
        this.position = position;
    }

    public static List<String> compare(final String nextCommand, final String command) {
        if (isCommandUpSign(command)) {
            return upCommandCompare(nextCommand, command);
        }
        return downCommandCompare(nextCommand, command);
    }

    private static boolean isCommandUpSign(final String command) {
        return Objects.equals(command, BRIDGE_POSITION_UP.getCommand());
    }

    private static List<String> upCommandCompare(final String nextCommand, final String command) {
        if (isEquals(nextCommand, command)) {
            return List.of(RIGHT_SIGN, BLANK_SIGN);
        }
        return List.of(WRONG_SIGN, BLANK_SIGN);
    }

    private static List<String> downCommandCompare(final String nextCommand, final String command) {
        if (isEquals(nextCommand, command)) {
            return List.of(BLANK_SIGN, RIGHT_SIGN);
        }
        return List.of(BLANK_SIGN, WRONG_SIGN);
    }

    private static boolean isEquals(final String nextCommand, final String command) {
        return Objects.equals(nextCommand, command);
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
