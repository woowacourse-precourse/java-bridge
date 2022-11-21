package bridge.model.valid;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class GameCommandValidatorTest {

    @DisplayName("R, Q 중 하나를 입력하지 않으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"r", "q", "RQ"})
    void invalidGameCommandInputTest(String input) {
        InputValidator inputValidator = new GameCommandValidator();
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputValidator.validateInput(input));
    }

    @DisplayName("R, Q 중 하나를 입력하면 예외가 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    void validGameCommandInputTest(String input) {
        InputValidator inputValidator = new GameCommandValidator();
        assertThatNoException()
                .isThrownBy(() -> inputValidator.validateInput(input));
    }
}
