package Utils;

public class Validation {
    public static void bridgeSize(int size) {
        if (size < 3 || size > 20) {
            Error.generate(Message.SIZE);
        }
    }
}
