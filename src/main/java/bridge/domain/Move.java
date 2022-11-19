package bridge.domain;

import java.util.Arrays;

public enum Move {
    UP("U", 1),
    DOWN("D", 0);

    final String direction;
    final int number;

    Move(String direction, int number) {
        this.direction = direction;
        this.number = number;
    }

    public static Move reverseMove(String direction) {
        return Arrays.stream(values())
                .filter(move -> !move.direction.equals(direction))
                .findAny()
                .get();
    }

    public String getDirection() {
        return direction;
    }

    public static String convertDirection(int number) {
        return Arrays.stream(Move.values())
                .filter(move -> move.number == number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 숫자 입력"))
                .getDirection();
    }

    public static Move from(String direction) {
        return Arrays.stream(Move.values())
                .filter(move -> move.direction.equals(direction))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 방향 입력"));
    }
}
