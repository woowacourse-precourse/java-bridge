package bridge.domain;

import java.util.Arrays;
import java.util.Objects;

enum Position {
    UP("U"),
    DOWN("D");

    private final String bridgeType;

    Position(String bridgeType) {
        this.bridgeType = bridgeType;
    }

    public static Position from(String move) {
        return Arrays.stream(Position.values())
                .filter(it -> Objects.equals(it.bridgeType, move))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("U,D 만 입력 가능합니다"));
    }
}
