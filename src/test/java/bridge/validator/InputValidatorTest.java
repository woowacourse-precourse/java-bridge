package bridge.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    @DisplayName("다리의 사이즈가 자연수가 아닌 경우 예외 발생")
    @Test
    void validateNumberTest() {
        String input = "숫자 아님";

        assertThatThrownBy(() -> InputValidator.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 사이즈가 3 이상 20 이하의 자연수가 아닌 경우 예외 발생")
    @Test
    void validateBridgeSizeWrongTest() {
        String input = "25";

        assertThatThrownBy(() -> InputValidator.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 사이즈가 3 이상 20 이하의 자연수인 경우 정상 작동")
    @Test
    void validateBridgeSizeRightTest() {
        String input = "3";

        assertThatCode(() -> InputValidator.validateBridgeSize(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("플레이어의 이동이 올바르지 않은 경우 예외 발생")
    @Test
    void validateMovingWrongTest() {
        String moving = "1";

        assertThatThrownBy(() -> InputValidator.validateMoving(moving))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어의 이동이 올바른 경우 정상 작동")
    @ParameterizedTest
    @ValueSource(strings = { "U", "D" })
    void validateMovingRightTest(String moving) {
        assertThatCode(() -> InputValidator.validateMoving(moving))
                .doesNotThrowAnyException();
    }

}
