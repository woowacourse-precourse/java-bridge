package bridge.domain;

import java.util.Arrays;

public enum Direction {
    UP(1, "U"),
    DOWN(0, "D");

    private static final String INVALID_CODE_RANGE_MESSAGE = "0과 1사이의 값을 입력해주세요.";
    private static final String INVALID_INITIAL_LETTER_MESSAGE = "U와 D 중 하나의 값을 입력해주세요.";

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
                .orElseThrow(() -> new IllegalArgumentException(INVALID_CODE_RANGE_MESSAGE))
                .command;
    }

    public static Direction toEnum(String command) {
        return Arrays.stream(values())
                .filter(direction -> direction.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_INITIAL_LETTER_MESSAGE));
    }

    public boolean isNotSameDirection(Direction direction) {
        return this != direction;
    }
}
