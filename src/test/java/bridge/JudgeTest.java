package bridge;

import bridge.constant.SuccessFail;
import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.constant.SuccessFail.FAIL;
import static bridge.constant.SuccessFail.SUCCESS;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class JudgeTest {
    @Test
    void isSuccessTest_SUCCESS() {
        List<String> bridge = List.of("U", "D", "U");
        List<String> player = List.of("U", "D", "U");

        Judge judge = new Judge(bridge, player);

        SuccessFail isSuccess = judge.isSuccess();
        assertThat(isSuccess).isEqualTo(SUCCESS);
    }

    @Test
    void isSuccessTest_FAIL() {
        List<String> bridge = List.of("U", "D", "U");
        List<String> player = List.of("U", "D", "D");

        Judge judge = new Judge(bridge, player);

        SuccessFail isSuccess = judge.isSuccess();
        assertThat(isSuccess).isEqualTo(FAIL);
    }

    @Test
    void isFinish_true1() {
        List<String> bridge = List.of("U", "D", "U");
        List<String> player = List.of("U", "U");

        Judge judge = new Judge(bridge, player);

        boolean isFinish = judge.isFinish();
        assertThat(isFinish).isEqualTo(true);
    }

    @Test
    void isFinish_true2() {
        List<String> bridge = List.of("U", "D", "U");
        List<String> player = List.of("U", "D", "U");

        Judge judge = new Judge(bridge, player);

        boolean isFinish = judge.isFinish();
        assertThat(isFinish).isEqualTo(true);
    }

    @Test
    void isFinish_true3() {
        List<String> bridge = List.of("U", "D", "U");
        List<String> player = List.of("U", "D", "D");

        Judge judge = new Judge(bridge, player);

        boolean isFinish = judge.isFinish();
        assertThat(isFinish).isEqualTo(true);
    }

    @Test
    void isFinish_false() {
        List<String> bridge = List.of("U", "D", "U");
        List<String> player = List.of("U", "D");

        Judge judge = new Judge(bridge, player);

        boolean isFinish = judge.isFinish();
        assertThat(isFinish).isEqualTo(false);
    }

}