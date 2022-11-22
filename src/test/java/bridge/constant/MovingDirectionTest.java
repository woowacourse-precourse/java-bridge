package bridge.constant;

import static bridge.constant.MovingDirection.U;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 제한된_방향을_가리키는_숫자외에_입력의경우_예외발생() throws Exception {
        assertThatThrownBy(() -> {
            MovingDirection.getDirection(3);
        }).isInstanceOf(IllegalStateException.class);
    }
}