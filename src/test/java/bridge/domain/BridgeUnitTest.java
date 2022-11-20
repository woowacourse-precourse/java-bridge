package bridge.domain;

import bridge.domain.bridge.BridgeUnit;
import org.junit.jupiter.api.Test;

import static bridge.domain.bridge.BridgeUnit.DOWN;
import static bridge.domain.bridge.BridgeUnit.UP;
import static bridge.support.ErrorMessage.INVALID_BRIDGE_UNIT_CODE_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeUnitTest {

    @Test
    void from_0이_들어오는_경우_DOWN을_리턴한다() {
        //given
        int number = 0;

        //when
        BridgeUnit res = BridgeUnit.from(number);

        //then
        assertThat(res).isEqualTo(DOWN);
    }

    @Test
    void from_1이_들어오는_경우_UP을_리턴한다() {
        //given
        int number = 1;

        //when
        BridgeUnit res = BridgeUnit.from(number);

        //then
        assertThat(res).isEqualTo(UP);
    }

    @Test
    void from_0_또는_1_이외의_값이_들어오는_경우_예와가_발생한다() {
        //given
        int number = 3;

        //when then
        assertThatThrownBy(() -> BridgeUnit.from(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_BRIDGE_UNIT_CODE_ERROR);
    }

    @Test
    void from_D가_들어오는_경우_DOWN을_리턴한다() {
        //given
        String code = "D";

        //when
        BridgeUnit res = BridgeUnit.from(code);

        //then
        assertThat(res).isEqualTo(DOWN);
    }

    @Test
    void from_U이_들어오는_경우_UP을_리턴한다() {
        //given
        String code = "U";

        //when
        BridgeUnit res = BridgeUnit.from(code);

        //then
        assertThat(res).isEqualTo(UP);
    }

    @Test
    void from_D_또는_U_이외의_값이_들어오는_경우_예와가_발생한다() {
        //given
        String code = "q";

        //when then
        assertThatThrownBy(() -> BridgeUnit.from(code))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_BRIDGE_UNIT_CODE_ERROR);
    }
}