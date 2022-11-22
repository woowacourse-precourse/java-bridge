package bridge.Vaildator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import bridge.Constant;
import org.junit.jupiter.api.Test;

class VaildatorUpDownTest {
    @Test
    void U_D_외_다른글자_작성시_에러() {
        String check = "";
        try {
            new VaildatorUpDown("ㅕ");
        } catch (IllegalArgumentException e) {
            check = "error";
            assertThat(e.getMessage()).isEqualTo(Constant.ERROR + Constant.INPUT_WRONG_UP_DOWN_SELECT);
        }
        assertThat(check).isEqualTo("error");
    }

    @Test
    void U_D_외_다른글자_작성시_에러_두번째() {
        String check = "";
        try {
            new VaildatorUpDown("1");
        } catch (IllegalArgumentException e) {
            check = "error";
            assertThat(e.getMessage()).isEqualTo(Constant.ERROR + Constant.INPUT_WRONG_UP_DOWN_SELECT);
        }
        assertThat(check).isEqualTo("error");
    }

    @Test
    void U_D_작성시_에러안뜨는지() {
        String check = "";
        try {
            new VaildatorUpDown("U");
        } catch (IllegalArgumentException e) {
            check = "error";
            assertThat(e.getMessage()).isEqualTo(Constant.ERROR + Constant.INPUT_WRONG_UP_DOWN_SELECT);
        }
        assertThat(check).isEqualTo("");
    }

}