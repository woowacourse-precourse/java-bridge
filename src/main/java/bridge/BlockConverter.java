package bridge;

import java.util.Arrays;

public enum BlockConverter {
    DOWN(0, "D"),
    UP(1, "U");

    private int number;
    private String message;

    BlockConverter(int number, String message) {
        this.number = number;
        this.message = message;
    }

    public static String getMessageFromNumber(int number) {
        return Arrays.stream(values())
                .filter(value -> value.number == number)
                .findFirst()
                .get()
                .message;
    }
}
