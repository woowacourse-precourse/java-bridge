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

    public static Move other(Move move) {
        return Arrays.stream(values())
                .filter(other -> other != move)
                .findAny()
                .get();
    }

    public static String convertDirection(int number) {
        return Arrays.stream(Move.values())
                .filter(move -> move.number == number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(GameException.INVALID_BRIDGE_GENERATE.getMessage()))
                .direction;
    }

    public static Move from(String direction) {
        return Arrays.stream(Move.values())
                .filter(move -> move.direction.equals(direction))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(GameException.INVALID_DIRECTION.getMessage()));
    }
}
