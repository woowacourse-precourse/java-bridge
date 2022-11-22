package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class MovingTest {
    @Test
    void 랜덤한_숫자_1이_들어올_경우_U를_반환한다() {
        assertThat(Moving.findDirectionByRandomValue(1)).isEqualTo(Moving.UP);
    }

    @Test
    void 랜덤한_숫자_0이_들어올_경우_D를_반환한다() {
        assertThat(Moving.findDirectionByRandomValue(0)).isEqualTo(Moving.DOWN);
    }

    @Test
    void 랜덤한_숫자_0과_1이_아닐경우_예외를_발생한다() {
        assertThatThrownBy(() -> Moving.findDirectionByRandomValue(3))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Moving.findDirectionByRandomValue(5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}