package bridge.domain;

import java.util.Arrays;

public enum GameMoving {
    DOWN(0, "D"),
    UP(1, "U");

    private final int number;
    private final String message;

    GameMoving(int number, String message) {
        this.number = number;
        this.message = message;
    }

    public static String getMovingFromNumber(int number) {
        return Arrays.stream(values())
                .filter(value -> value.number == number)
                .findFirst()
                .get()
                .message;
    }

    public static boolean isDown(String target) {
        return target.equals(DOWN.message);
    }

    public static boolean isUp(String target) {
        return target.equals(UP.message);
    }

    @Override
    public String toString() {
        return this.message;
    }
}
