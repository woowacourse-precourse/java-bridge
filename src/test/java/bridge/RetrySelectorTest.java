package bridge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RetrySelectorTest {

    @Test
    void 재시작_커맨드_getter_테스트() {
        RetrySelector retry = RetrySelector.getRetrySelectorType("R");
        RetrySelector quit = RetrySelector.getRetrySelectorType("Q");

        assertThat(retry).isEqualTo(RetrySelector.RETRY);
        assertThat(quit).isEqualTo(RetrySelector.QUIT);
    }
}