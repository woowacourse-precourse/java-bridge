package bridge.domain.game;

import bridge.utils.common.CommandConst;
import bridge.utils.message.ExceptionMessageUtils;
import java.util.Arrays;

public enum BridgeTile {
    DOWN(CommandConst.PLAYER_MOVE_DOWN, 0),
    UP(CommandConst.PLAYER_MOVE_UP, 1);

    private final String command;
    private final int value;

    BridgeTile(String command, int value) {
        this.command = command;
        this.value = value;
    }

    public static BridgeTile findTile(String command) {
        return Arrays.stream(BridgeTile.values())
                .filter(tile -> tile.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessageUtils.WRONG_PLAYER_MOVE
                        .getMessage()));
    }

    public static String mapToCommand(int value) {
        if (value == BridgeTile.DOWN.value) {
            return BridgeTile.DOWN.command;
        }
        return BridgeTile.UP.command;
    }
}
