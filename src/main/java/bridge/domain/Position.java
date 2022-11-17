package bridge.domain;

import java.util.Arrays;
import java.util.Objects;

public enum Position {
    UP("U"),
    DOWN("D");

    private final String position;

    Position(String position) {
        this.position = position;
    }

    public static Position from(String move) {
        return Arrays.stream(Position.values())
                .filter(it -> Objects.equals(it.position, move))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("U,D 만 입력 가능합니다"));
    }
}
