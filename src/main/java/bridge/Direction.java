package bridge;

import java.util.Arrays;

public enum Direction {
    UP(1, "U"),
    DOWN(0, "D");


    private final Integer code;
    private final String command;

    Direction(Integer code, String command) {
        this.code = code;
        this.command = command;
    }

    public static String toCommand(int code) {
        return Arrays.stream(values())
                .filter(direction -> direction.code == code)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("0과 1사이의 값을 입력해주세요."))
                .command;
    }

    public static Direction toEnum(String command) {
        return Arrays.stream(values())
                .filter(direction -> direction.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("U와 D 중 하나의 값을 입력해주세요."));
    }

    public boolean isNotSameDirection(Direction direction) {
        return this != direction;
    }
}
