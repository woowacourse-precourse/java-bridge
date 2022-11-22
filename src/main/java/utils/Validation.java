package utils;

public class Validation {
    public static void bridgeSize(int size) {
        if (size < 3 || size > 20) {
            Error.generate(Message.SIZE);
        }
    }

    public static void moving(String moving) {
        if (!moving.equals("U") && !moving.equals("D")) {
            Error.generate(Message.MOVE);
        }
    }

    public static void restart(String moving) {
        if (!moving.equals("R") && !moving.equals("Q")) {
            Error.generate(Message.RETRY);
        }
    }
}
