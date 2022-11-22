package bridge.Vaildator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import bridge.Constant;
import org.junit.jupiter.api.Test;

class VaildatorRetryQuitTest {

    @Test
    void R_Q_외_다른글자_작성시_에러() {
        String check = "";
        try {
            new VaildatorRetryQuit("ㅕ");
        } catch (IllegalArgumentException e) {
            check = "error";
            assertThat(e.getMessage()).isEqualTo(Constant.ERROR + Constant.INPUT_WRONG_RETRY_SELECT);
        }
        assertThat(check).isEqualTo("error");
    }

    @Test
    void R_Q_외_다른글자_작성시_에러_두번째() {
        String check = "";
        try {
            new VaildatorRetryQuit("1");
        } catch (IllegalArgumentException e) {
            check = "error";
            assertThat(e.getMessage()).isEqualTo(Constant.ERROR + Constant.INPUT_WRONG_RETRY_SELECT);
        }
        assertThat(check).isEqualTo("error");
    }

    @Test
    void R_Q_작성시_에러안뜨는지() {
        String check = "";
        try {
            new VaildatorRetryQuit("R");
        } catch (IllegalArgumentException e) {
            check = "error";
            assertThat(e.getMessage()).isEqualTo(Constant.ERROR + Constant.INPUT_WRONG_RETRY_SELECT);
        }
        assertThat(check).isEqualTo("");
    }

}