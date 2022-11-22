package bridge.domain;

import java.util.Arrays;
import java.util.Objects;

/**
 * 게임에서 위, 아래의 위치를 담당하는 클래스
 */
enum Position {
    UP("U"),
    DOWN("D");

    private final String bridgeType;

    Position(final String bridgeType) {
        this.bridgeType = bridgeType;
    }

    public static Position from(final String move) {
        return Arrays.stream(Position.values())
                .filter(it -> Objects.equals(it.bridgeType, move))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("U,D 만 입력 가능합니다"));
    }
}
