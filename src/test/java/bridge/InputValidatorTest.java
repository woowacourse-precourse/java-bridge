package bridge;

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
}
