package bridge;

import java.util.Arrays;

public enum Direction {
    UP("U"),
    DOWN("D");

    private static final String ERROR_INVALID_INPUT = "[ERROR] 유효한 입력이 아닙니다.";
    private String symbol;

    Direction(String symbol) {
        this.symbol = symbol;
    }

    public static Direction of(String input) {
        return Arrays.stream(Direction.values())
                .filter(t -> t.symbol.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_INPUT));
    }
}
