package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BridgeGameRepositoryTest {

    private BridgeGameRepository bridgeGameRepository;

    @BeforeEach
    void init() {
        bridgeGameRepository = new BridgeGameRepository();
    }

    @DisplayName("round의 기본값은 1이다.")
    @Test
    void When_AfterSetBridgeGameInfo_Expect_RoundIsOne() {
        assertThat(bridgeGameRepository.getRound()).isEqualTo(1);
    }

    @DisplayName("tryCount의 기본값은 1이다.")
    @Test
    void When_AfterSetBridgeGameInfo_Expect_TryCountIsOne() {
        assertThat(bridgeGameRepository.getTryCount()).isEqualTo(1);
    }

    @DisplayName("다음 라운드로 넘어갈시 round 값이 1 증가한다.")
    @Test
    void When_AfterGoToNextRound_Expect_RoundPlusOne() {
        bridgeGameRepository.addOneToRound();
        assertThat(bridgeGameRepository.getRound()).isEqualTo(2);
    }

    @DisplayName("retry를 하면")
    @Nested
    class Retry {

        @BeforeEach
        void retry() {
            bridgeGameRepository.retry();
        }

        @DisplayName("tryCount 값이 1 증가한다.")
        @Test
        void When_AfterRetry_Expect_TryCountPlusOne() {
            assertThat(bridgeGameRepository.getTryCount()).isEqualTo(2);
        }

        @DisplayName("round는 기본값으로 변경된다.")
        @Test
        void When_AfterRetry_Expect_RoundIsOne() {
            assertThat(bridgeGameRepository.getRound()).isEqualTo(1);
        }
    }

    @DisplayName("현재라운드가 finalRound와")
    @Nested
    class FinalRound {

        @DisplayName("일치하면 true를 반환한다.")
        @Test
        void When_FinalRoundIsEqualToRound_Expect_True() {
            bridgeGameRepository.addOneToRound();
            bridgeGameRepository.addOneToRound();
            assertThat(bridgeGameRepository.isFinalRound(new Bridge(List.of("U","U","U")))).isTrue();
        }

        @DisplayName("일치하지않으면 false를 반환한다.")
        @Test
        void When_FinalRoundIsNotEqualToRound_Expect_False() {
            assertThat(bridgeGameRepository.isFinalRound(new Bridge(List.of("U","U","U")))).isFalse();
        }
    }
}