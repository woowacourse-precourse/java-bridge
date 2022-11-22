package bridge.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}
