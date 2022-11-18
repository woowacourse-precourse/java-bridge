package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DirectionTest {
    @Test
    void 랜덤한_숫자_1이_들어올_경우_U를_반환한다() {
        assertThat(Direction.findDirectionByRandomValue(1)).isEqualTo(Direction.U);
    }
}