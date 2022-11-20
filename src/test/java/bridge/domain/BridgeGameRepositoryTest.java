package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BridgeGameRepositoryTest {

    private final BridgeGameRepository bridgeGameRepository = new BridgeGameRepository();

    @BeforeEach
    void init() {
        bridgeGameRepository.setBridgeGameInfo(new BridgeSize(3));
    }

    @DisplayName("round의 기본값은 1이다.")
    @Test
    void test1() {
        assertThat(bridgeGameRepository.findRound()).isEqualTo(1);
    }

    @DisplayName("tryCount의 기본값은 1이다.")
    @Test
    void test2() {
        assertThat(bridgeGameRepository.findTryCount()).isEqualTo(1);
    }

    @DisplayName("다음 라운드로 넘어갈시 round 값이 1 증가한다.")
    @Test
    void test3() {
        bridgeGameRepository.goToNextRound();
        assertThat(bridgeGameRepository.findRound()).isEqualTo(2);
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
        void test1() {
            assertThat(bridgeGameRepository.findTryCount()).isEqualTo(2);
        }

        @DisplayName("round는 기본값으로 변경된다.")
        @Test
        void test2() {
            assertThat(bridgeGameRepository.findRound()).isEqualTo(1);
        }
    }

    @DisplayName("현재라운드가 finalRound와")
    @Nested
    class FinalRound {
        
        @DisplayName("일치하면 true를 반환한다.")
        @Test
        void test1() {
            bridgeGameRepository.goToNextRound();
            bridgeGameRepository.goToNextRound();
            assertThat(bridgeGameRepository.isFinalRound()).isTrue();
        }

        @DisplayName("일치하지않으면 false를 반환한다.")
        @Test
        void test2() {
            assertThat(bridgeGameRepository.isFinalRound()).isFalse();
        }
    }
}