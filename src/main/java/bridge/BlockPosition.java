package bridge;

import java.util.Arrays;

public enum BlockPosition {
    U(1), D(0);

    private final int number;

    BlockPosition(int number) {
        this.number = number;
    }

    public static BlockPosition from(String position) {
        return Arrays.stream(BlockPosition.values())
                .filter(number -> number.matches(position))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 잘못된 입력입니다."));
    }

    public static BlockPosition from(int type) {
        return Arrays.stream(BlockPosition.values())
                .filter(number -> number.matches(type))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 잘못된 입력입니다."));
    }

    private boolean matches(String name) {
        return this.name().equals(name);
    }

    private boolean matches(int number) {
        return this.number == number;
    }
}
