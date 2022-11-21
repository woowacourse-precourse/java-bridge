package bridge.domain;

import bridge.domain.bridge.Move;
import org.junit.jupiter.api.Test;

import static bridge.domain.bridge.Move.DOWN;
import static bridge.domain.bridge.Move.UP;
import static bridge.support.ErrorMessage.INVALID_BRIDGE_UNIT_CODE_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoveTest {

    @Test
    void from_0이_들어오는_경우_DOWN을_리턴한다() {
        //given
        int number = 0;

        //when
        Move res = Move.from(number);

        //then
        assertThat(res).isEqualTo(DOWN);
    }

    @Test
    void from_1이_들어오는_경우_UP을_리턴한다() {
        //given
        int number = 1;

        //when
        Move res = Move.from(number);

        //then
        assertThat(res).isEqualTo(UP);
    }

    @Test
    void from_0_또는_1_이외의_값이_들어오는_경우_예와가_발생한다() {
        //given
        int number = 3;

        //when then
        assertThatThrownBy(() -> Move.from(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_BRIDGE_UNIT_CODE_ERROR);
    }

    @Test
    void from_D가_들어오는_경우_DOWN을_리턴한다() {
        //given
        String code = "D";

        //when
        Move res = Move.from(code);

        //then
        assertThat(res).isEqualTo(DOWN);
    }

    @Test
    void from_U이_들어오는_경우_UP을_리턴한다() {
        //given
        String code = "U";

        //when
        Move res = Move.from(code);

        //then
        assertThat(res).isEqualTo(UP);
    }

    @Test
    void from_D_또는_U_이외의_값이_들어오는_경우_예와가_발생한다() {
        //given
        String code = "q";

        //when then
        assertThatThrownBy(() -> Move.from(code))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_BRIDGE_UNIT_CODE_ERROR);
    }
}