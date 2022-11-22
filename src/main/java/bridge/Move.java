package bridge;

import java.util.Arrays;

public enum Move {

    UP("U"),
    DOWN("D");

    private final String value;

    Move(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static Move from(final String input) {
        return Arrays.stream(values())
                .filter(move -> move.value.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] U 또는 D만 입력 가능합니다."));
    }
}
