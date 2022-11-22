
package bridge.exception;

import java.util.function.Function;

public class Validate {
    private static final int MAX_RETRY = 3;

    public static void validate(Function<Void, Void>... function) {
        for(int i = 0; i < MAX_RETRY; i++) {
            try {
                function.apply();
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        throw new Exception.RETRY_FAILED_EXCEPTION.getException();
    }
}