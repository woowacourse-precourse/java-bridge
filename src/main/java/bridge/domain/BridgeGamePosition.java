package bridge.domain;

import java.util.Arrays;
import java.util.Objects;

public enum BridgeGamePosition {
    UP("U"),
    DOWN("D");

    private final String move;

    BridgeGamePosition(final String move) {
        this.move = move;
    }

    public static BridgeGamePosition checkBridgePosition(final String move) {
        return Arrays.stream(values())
                .filter(e -> Objects.equals(e.move, move))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("U,D 만 입력 가능합니다"));
    }
}
