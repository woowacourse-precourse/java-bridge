package bridge.view.inputview;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.Application;
import bridge.constant.ExceptionMessage;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputBridgeSizeTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("다리의 사이즈 입력 값이 정수 형태가 아닌 경우 예외가 발생한다.")
    @ValueSource(strings = {"a", "1a", "3 ", "112ㄱ", "2147483648"})
    @ParameterizedTest
    void inputBridgeSizeTypeExceptionTest(String inputBridgeSize) {
        assertSimpleTest(() -> {
            runException(inputBridgeSize);
            assertThat(output()).contains(ERROR_MESSAGE);
            assertThat(output()).contains(ExceptionMessage.INVALID_BRIDGE_SIZE_TYPE.getString());
        });
    }

    @DisplayName("다리의 사이즈 입력 값의 범위가 3과 20 사이가 아닌 경우 예외가 발생한다.")
    @ValueSource(strings = {"-1", "0", "2", "25", "2147483647"})
    @ParameterizedTest
    void inputBridgeSizeRangeExceptionTest(String inputBridgeSize) {
        assertSimpleTest(() -> {
            runException(inputBridgeSize);
            assertThat(output()).contains(ERROR_MESSAGE);
            assertThat(output()).contains(ExceptionMessage.INVALID_BRIDGE_SIZE_RANGE.getString());
        });
    }

    @DisplayName("다리의 사이즈 입력 값의 범위가 3과 20 사이인 경우 예외가 발생하지 않는다.")
    @ValueSource(strings = {"3", "4", "5", "19", "20"})
    @ParameterizedTest
    void inputBridgeSizeCorrectTest(String inputBridgeSize) {
        assertSimpleTest(() -> {
            runException(inputBridgeSize);
            assertThat(output()).doesNotContain(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
