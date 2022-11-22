package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RetryTest {

    Retry retry;

    @BeforeEach
    void setUpRetry() {
        retry = new Retry();
    }

    @Test
    void countTry() {
        retry.countTry();
        assertThat(new Retry(2)).isEqualTo(retry);
    }

    @Test
    void checkRetryReturnTrue() {
        assertTrue(retry.checkRetry("R"));
    }

    @Test
    void checkRetryReturnFalse() {
        assertFalse(retry.checkRetry("Q"));
    }

    @Test
    void checkRetryException() {
        assertThatThrownBy(() -> retry.checkRetry("U"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
