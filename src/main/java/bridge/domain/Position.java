package bridge.domain;

import bridge.command.ReadMovingCommand;

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

    public static Position from(final ReadMovingCommand movingCommand) {
        return Arrays.stream(Position.values())
                .filter(it -> Objects.equals(it.bridgeType, movingCommand.getMoving()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("U,D 만 입력 가능합니다"));
    }

    static Position from(final String key) {
        return Arrays.stream(Position.values())
                .filter(it -> Objects.equals(it.bridgeType, key))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("U,D 만 입력 가능합니다"));
    }
}
