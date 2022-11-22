package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BridgeGameRepositoryTest {

    private BridgeGameRepository bridgeGameRepository;

    @BeforeEach
    private void init() {
        bridgeGameRepository = new BridgeGameRepository();
    }

    @DisplayName("round의 기본값은 1이다.")
    @Test
    public void When_AfterSetBridgeGameInfo_Expect_RoundIsOne() {
        assertThat(bridgeGameRepository.getRound()).isEqualTo(1);
    }

    @DisplayName("tryCount의 기본값은 1이다.")
    @Test
    public void When_AfterSetBridgeGameInfo_Expect_TryCountIsOne() {
        assertThat(bridgeGameRepository.getTryCount()).isEqualTo(1);
    }

    @DisplayName("다음 라운드로 넘어갈시 round 값이 1 증가한다.")
    @Test
    public void When_AfterGoToNextRound_Expect_RoundPlusOne() {
        bridgeGameRepository.addOneToRound();
        assertThat(bridgeGameRepository.getRound()).isEqualTo(2);
    }

    @DisplayName("retry를 하면")
    @Nested
    class Retry {

        @BeforeEach
        private void retry() {
            bridgeGameRepository.retry();
        }

        @DisplayName("tryCount 값이 1 증가한다.")
        @Test
        public void When_AfterRetry_Expect_TryCountPlusOne() {
            assertThat(bridgeGameRepository.getTryCount()).isEqualTo(2);
        }

        @DisplayName("round는 기본값으로 변경된다.")
        @Test
        public void When_AfterRetry_Expect_RoundIsOne() {
            assertThat(bridgeGameRepository.getRound()).isEqualTo(1);
        }
    }
}