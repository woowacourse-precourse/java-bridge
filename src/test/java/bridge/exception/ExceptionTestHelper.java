package bridge.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

public class ExceptionTestHelper {

    public static void testIllegalArgumentException(TotalExceptionHandler exceptionHandler, String input) {
        assertThatThrownBy(() -> {
            exceptionHandler.handleException(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    public static void testIllegalStateException(TotalExceptionHandler exceptionHandler, List<String> input) {
        assertThatThrownBy(() -> {
            exceptionHandler.handleException(input);
        })
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("[ERROR]");
    }

    public static void testIllegalStateException(TotalExceptionHandler exceptionHandler, boolean input) {
        assertThatThrownBy(() -> {
            exceptionHandler.handleException(input);
        })
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("[ERROR]");
    }

    public static void testIllegalStateException(TotalExceptionHandler exceptionHandler, int input) {
        assertThatThrownBy(() -> {
            exceptionHandler.handleException(input);
        })
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("[ERROR]");
    }
}
