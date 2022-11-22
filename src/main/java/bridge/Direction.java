package bridge;

import java.util.Arrays;

public enum Direction {
    UP("U", 1),
    DOWN("D", 0);

    Direction(String name, int num) {
        this.name = name;
        this.num = num;
    }

    private final String name;
    private final int num;

    public static Direction of(int num) {
        return Arrays.stream(values()).filter(v -> v.num == num).findFirst().orElseThrow(
                () -> new IllegalArgumentException("[ERROR] 올바른 숫자를 입력해주세요.")
        );
    }

    public String getName() {
        return name;
    }
}
