package bridge.view.inputview;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.Application;
import bridge.constant.ExceptionMessage;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputMovingTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("이동 입력이 후보에 없는 경우 예외가 발생한다.")
    @ValueSource(strings = {"u", "d", "Up", "UU", "1", "0", "K"})
    @ParameterizedTest
    void inputMovingExceptionTest(String inputMoving) {
        assertRandomNumberInRangeTest(() -> {
            runException("10", inputMoving);
            assertThat(output()).contains(ERROR_MESSAGE);
            assertThat(output()).contains(ExceptionMessage.INVALID_MOVING.getString());
        }, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
    }

    @DisplayName("이동 입력이 후보에 있는 경우 예외가 발생하지 않는다.")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void inputMovingCorrectTest(String inputMoving) {
        assertRandomNumberInRangeTest(() -> {
            runException("10", inputMoving);
            assertThat(output()).doesNotContain(ERROR_MESSAGE);
        }, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
