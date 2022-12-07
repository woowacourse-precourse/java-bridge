package bridge.validator;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static bridge.utils.ErrorMessages.ERROR_NOT_INTEGER;
import static bridge.utils.ErrorMessages.ERROR_OUT_OF_RANGE;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeSizeValidatorTest extends NsTest {
    @DisplayName("다리 길이 입력값이 숫자가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"woowacourse", "is", "very", "funny"})
    void makeBridgeByOutOfRange(String bridgeSize) {
        assertSimpleTest(() -> {
            runException(bridgeSize);
            assertThat(output()).contains(ERROR_NOT_INTEGER);
        });
    }

    @DisplayName("다리 길이 입력값이 3~20 범위를 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "21", "2"})
    void makeBridgeByOutNotInteger(String bridgeSize) {
        assertSimpleTest(() -> {
            runException(bridgeSize);
            assertThat(output()).contains(ERROR_OUT_OF_RANGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
