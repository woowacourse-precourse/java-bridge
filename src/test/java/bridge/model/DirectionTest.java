package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class DirectionTest {
    @Test
    void 랜덤한_숫자_1이_들어올_경우_U를_반환한다() {
        assertThat(Direction.findDirectionByRandomValue(1)).isEqualTo(Direction.UP);
    }

    @Test
    void 랜덤한_숫자_0이_들어올_경우_D를_반환한다() {
        assertThat(Direction.findDirectionByRandomValue(0)).isEqualTo(Direction.DOWN);
    }

    @Test
    void 랜덤한_숫자_0과_1이_아닐경우_예외를_발생한다() {
        assertThatThrownBy(() -> Direction.findDirectionByRandomValue(3))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Direction.findDirectionByRandomValue(5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}