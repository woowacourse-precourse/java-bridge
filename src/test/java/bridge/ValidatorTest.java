package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.view.Validator;
import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest extends NsTest {
    private final Validator validator = new Validator();

    @DisplayName("다리 크기를 숫자가 아닌 값으로 입력했을 경우에 대한 예외 처리")
    @ValueSource(strings = {"fff", "4@@", "4.5"})
    @ParameterizedTest
    void bridgeSizeByString(String input) {
        assertThatThrownBy(() -> validator.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 크기가 3과 20 사이의 값이 아닌 경우에 대한 예외 처리")
    @ValueSource(strings = {"-8", "2", "100"})
    @ParameterizedTest
    void bridgeSizeByWrongNumber(String input) {
        assertThatThrownBy(() -> validator.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 이동할 칸이 U 또는 D가 아닌 경우에 대한 예외 처리")
    @ValueSource(strings = {"R", "Q", "u", "d"})
    @ParameterizedTest
    void movingByWrongString(String input) {
        assertThatThrownBy(() -> validator.validateMoving(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
