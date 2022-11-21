package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsTest {

    @Test
    @DisplayName("시도 횟수를 추가한다.")
    void update() {
        Statistics statistics = new Statistics();
        assertThat(statistics.getTryCount()).isEqualTo(1);
        statistics.update();
        statistics.update();
        assertThat(statistics.getTryCount()).isEqualTo(3);
    }
}