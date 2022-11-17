package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameCounterTest {
    @Nested
    @DisplayName("isGameOver 메소드 테스트")
    class IsGameOver {
        @ParameterizedTest
        @CsvSource(value = {"3", "5", "10", "10000", "100"})
        void 카운터의_값이_한계값에_도달했는지_테스트(int limit) {
            BridgeGameCounter bridgeGameCounter = new BridgeGameCounter(limit);

            for (int i = 0; i < limit; i++) {
                bridgeGameCounter.addCount();
            }
            assertThat(bridgeGameCounter.isGameOver()).isTrue();
        }
    }

    @Nested
    @DisplayName("reset 메소드 테스트")
    class Reset {
        @ParameterizedTest
        @CsvSource(value = {"3", "5", "10", "10000", "100"})
        void 리셋_기능을_테스트(int limit) {
            BridgeGameCounter bridgeGameCounter = new BridgeGameCounter(limit);

            for (int i = 0; i < limit; i++) {
                bridgeGameCounter.addCount();
            }
            bridgeGameCounter.reset();

            assertThat(bridgeGameCounter.isGameOver()).isFalse();
        }
    }
}