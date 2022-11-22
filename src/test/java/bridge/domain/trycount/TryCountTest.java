package bridge.domain.trycount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TryCountTest {

    @DisplayName("시도 횟수는 1부터 시작한다.")
    @Test
    void startValueIs0() {
        // when
        TryCount start = TryCount.start();

        // then
        assertThat(start.count()).isEqualTo(1);
    }

    @DisplayName("시도 횟수를 증가시킬 수 있다.")
    @Test
    void countUp() {
        // given
        TryCount count = TryCount.start();

        // when
        count = count.up();

        // then
        assertThat(count.count()).isEqualTo(2);
    }
}