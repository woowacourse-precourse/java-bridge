package bridge;

import bridge.exception.InputValidator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class InputValidatorTest {

    @ValueSource(strings = {"", "10j", "asd", " "})
    @ParameterizedTest
    void 다리_길이_입력이_숫자가_아닌_경우(String input) {
        assertThatThrownBy(() -> InputValidator.inputBridgeSizeValidate(input))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @ValueSource(strings = {"u", "A", "5", "DD", " "})
    @ParameterizedTest
    void 이동할_칸의_입력이_올바르지_않은_경우(String input) {
        assertThatThrownBy(() -> InputValidator.inputMovingValidate(input))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @ValueSource(strings = {"q", "A", "5", "RR", " "})
    @ParameterizedTest
    void 게임_다시_시도_여부_입력이_올바르지_않은_경우(String input) {
        assertThatThrownBy(() -> InputValidator.inputGameCommandValidate(input))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
