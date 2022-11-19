package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.BridgeGameCounter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameCounterTest {
    @Nested
    @DisplayName("reset 메소드 테스트")
    class Reset {
        @ParameterizedTest
        @CsvSource(value = {"3", "5", "10", "10000", "100"})
        void 리셋_기능을_테스트(int size) {
            BridgeGameCounter bridgeGameCounter = new BridgeGameCounter();

            for (int i = 0; i < size; i++) {
                bridgeGameCounter.addCount();
            }
            bridgeGameCounter.reset();

            assertThat(bridgeGameCounter.getCount()).isEqualTo(1);
        }
    }
}