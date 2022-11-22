package bridge.constant;

import static bridge.constant.MovingDirection.U;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MovingDirectionTest {

    @Test
    void 입력된_문자열_방향과_일치하는_enum반환성공() throws Exception {
        MovingDirection movingDirection = MovingDirection.from("U");
        assertThat(movingDirection).isEqualTo(U);
    }

    @Test
    void 입력된_숫자와_일치하는_방향의_문자열_반환성공() throws Exception {
        String direction = MovingDirection.getDirection(1);
        assertThat(direction).isEqualTo("U");
    }

}