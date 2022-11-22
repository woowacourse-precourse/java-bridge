package bridge.domain.bridgegame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RetryTest {

    @Test
    void 재시작_타입_반환_테스트() {
        assertThat(Retry.findRetry("R")).isEqualTo(Retry.RESTART);
        assertThat(Retry.findRetry("Q")).isEqualTo(Retry.QUIT);
    }

    @Test
    void 재시작_타입_반환_예외_테스트() {
        assertThat(Retry.findRetry("R")).isNotEqualTo(Retry.QUIT);
        assertThat(Retry.findRetry("Q")).isNotEqualTo(Retry.RESTART);
    }

}