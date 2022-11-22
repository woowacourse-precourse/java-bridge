package bridge.domain.bridgegame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTypeTest {

    @Test
    void 다리_타입_찾기_테스트() {
        assertThat(Retry.findRetry("R")).isEqualTo(Retry.RESTART);
        assertThat(Retry.findRetry("Q")).isEqualTo(Retry.QUIT);
    }

    @Test
    void 다리_타입_찾기_예외_테스트() {
        assertThat(Retry.findRetry("R")).isNotEqualTo(Retry.QUIT);
        assertThat(Retry.findRetry("Q")).isNotEqualTo(Retry.RESTART);
    }

}