package bridge.model;

import org.junit.jupiter.api.Test;

import static bridge.model.Retry.isRetry;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RetryTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 재시작_테스트() {
        assertThat(isRetry("Q")).isFalse();
        assertThat(isRetry("R")).isTrue();
    }

    @Test
    void 재시작_예외_테스트() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> isRetry("q"));
        String message = exception.getMessage();
        assertThat(message).contains(ERROR_MESSAGE);
    }
}
