package bridge;

import bridge.constants.ErrorMessage;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeTest extends NsTest {

    @DisplayName("다리_길이_범위_테스트")
    @Test
    void bridgeLengthRange() {
        assertSimpleTest(() -> {
            runException("30");
            assertThat(output()).contains(ErrorMessage.ERROR_NOT_VALID_LENGTH.getDescription());
        });
    }
    @DisplayName("다리_길이_문자_테스트")
    @Test
    void bridgeLengthString() {
        assertSimpleTest(() -> {
            runException("J");
            assertThat(output()).contains(ErrorMessage.ERROR_NOT_INT.getDescription());
        });
    }
    @DisplayName("다리_길이_소수_테스트")
    @Test
    void bridgeLengthLong() {
        assertSimpleTest(() -> {
            runException("20.5");
            assertThat(output()).contains(ErrorMessage.ERROR_NOT_INT.getDescription());
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
