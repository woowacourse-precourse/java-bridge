package bridge.model.valid;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class MovingValidatorTest {

    @DisplayName("U, D 중 하나를 입력하지 않으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"u", "d", "UD"})
    void invalidMovingInputTest(String input) {
        InputValidator inputValidator = new MovingValidator();
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputValidator.validateInput(input));
    }

    @DisplayName("U, D 중 하나를 입력하면 예외가 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void validMovingInputTest(String input) {
        InputValidator inputValidator = new MovingValidator();
        assertThatNoException()
                .isThrownBy(() -> inputValidator.validateInput(input));
    }
}
