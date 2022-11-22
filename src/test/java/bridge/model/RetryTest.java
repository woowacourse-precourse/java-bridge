package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

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
}
