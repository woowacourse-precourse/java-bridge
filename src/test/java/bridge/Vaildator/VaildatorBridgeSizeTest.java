package bridge.Vaildator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import bridge.Application;
import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.Constant;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class VaildatorBridgeSizeTest {


    @Test
    void 글자_작성시_오류_테스트() {
        String check = "";
        try {
            new VaildatorBridgeSize("t");
        } catch (IllegalArgumentException e) {
            check = "error";
            assertThat(e.getMessage()).isEqualTo(Constant.ERROR + Constant.INPUT_BRIDGE_SIZE_STRING);
        }
        assertThat(check).isEqualTo("error");
    }


    @Test
    void 숫자가_범위를_넘어갈_시_오류_테스트() {
        String check = "";

        try {
            new VaildatorBridgeSize("2");
        } catch (IllegalArgumentException e) {
            check = "error";
            assertThat(e.getMessage()).isEqualTo(Constant.ERROR + Constant.INPUT_BRIDGE_SIZE_WRONG_RANGE);
        }
        assertThat(check).isEqualTo("error");

    }


}