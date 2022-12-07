package bridge.domain;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static bridge.utils.ErrorMessages.ERROR_NOT_INTEGER;
import static bridge.utils.ErrorMessages.ERROR_OUT_OF_RANGE;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class BridgeSizeTest extends NsTest {

    @DisplayName("다리 길이 입력값이 범위를 벗어난 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 2, 22, 100})
    void outOfRangeBridgeSizeTest(int bridgeSize) {
        assertThatThrownBy(() -> new BridgeSize(bridgeSize))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_OUT_OF_RANGE);
    }

    @DisplayName("다리 길이 입력값이 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"이", "s", "k", "y"})
    void notIntegerBridgeSizeTest(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(ERROR_NOT_INTEGER);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
