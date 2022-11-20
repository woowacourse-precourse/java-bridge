package bridge.enums;

import java.util.Arrays;

public enum BridgeMove {
    MOVE_UP("U"),
    MOVE_DOWN("D");

    private final String move;

    BridgeMove(String move) {
        this.move = move;
    }

    public String getMove() {
        return move;
    }

    public static BridgeMove getEnum(String inputMove) {
        return Arrays.stream(values())
                .filter(bridgeMove -> isMoveEqual(bridgeMove, inputMove))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static boolean isMoveEqual(BridgeMove bridgeMove, String inputMove) {
        return bridgeMove.move.equals(inputMove);
    }
}
