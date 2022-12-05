package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CounterTest {
    @Nested
    @DisplayName("reset 메소드 테스트")
    class Reset {
        @ParameterizedTest
        @CsvSource(value = {"3", "5", "10", "10000", "100"})
        void 리셋_기능을_테스트(int size) {
            Counter counter = new Counter();

            for (int i = 0; i < size; i++) {
                counter.addCount();
            }
            counter.reset();

            assertThat(counter.getCount()).isEqualTo(1);
        }
    }
}