package bridge.domain;

import bridge.constant.Constant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class DirectionTest {

    @DisplayName("0은 D, 1은 U를 반환해야 한다.")
    @Test
    void findMarkTest() {
        String up = Direction.findByCode(1);
        String down = Direction.findByCode(0);
        assertThat(up).isEqualTo(Constant.UP);
        assertThat(down).isEqualTo(Constant.DOWN);
    }
}