package bridge.exception;

import java.util.function.Supplier;

public class ExceptionHandler {
    public static final String ERROR_PREFIX = "[ERROR] ";

    public <T> T handleAndRetry(Supplier<T> method) {
        T input;
        try {
            input = method.get();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
            input = handleAndRetry(method);
        }
        return input;
    }
}
