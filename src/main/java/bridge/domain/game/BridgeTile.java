package bridge.domain.game;

import bridge.exception.domain.WrongGeneratorException;
import bridge.utils.common.BridgeConst;
import bridge.utils.common.CommandConst;
import bridge.utils.message.ExceptionMessageUtils;
import java.util.Arrays;

public enum BridgeTile {
    DOWN(CommandConst.PLAYER_MOVE_DOWN, BridgeConst.DOWN_TILE_VALUE),
    UP(CommandConst.PLAYER_MOVE_UP, BridgeConst.UP_TILE_VALUE);

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
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessageUtils
                        .WRONG_PLAYER_MOVE.getMessage()));
    }

    public static String mapToCommand(int value) {
        if (value == BridgeTile.DOWN.value) {
            return BridgeTile.DOWN.command;
        }
        if (value == BridgeTile.UP.value) {
            return BridgeTile.UP.command;
        }
        throw new WrongGeneratorException();
    }
}
