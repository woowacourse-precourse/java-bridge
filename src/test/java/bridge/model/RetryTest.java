package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RetryTest {

    @ParameterizedTest
    @CsvSource({"R, true", "Q, false"})
    void isRetry(String retryInput, boolean result) {
        Retry retry = Retry.valueOf(retryInput);

        boolean selectRetrying = retry.isRetry();

        Assertions.assertThat(selectRetrying).isEqualTo(result);
    }
}