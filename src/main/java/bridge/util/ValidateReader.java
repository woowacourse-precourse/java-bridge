package bridge.util;

public class ValidateReader {

    public static <T> T readUntilValidate(InputFunction<T> expression) {
        T input = null;
        do {
            try {
                input = expression.apply();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        } while (input == null);

        return input;
    }
}
