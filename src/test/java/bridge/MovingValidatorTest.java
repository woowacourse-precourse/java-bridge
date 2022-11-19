package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class MovingValidatorTest {
    private static final InputValidator inputValidator = new MovingValidator();

    @DisplayName("잘못된 이동할 칸을 입력 받으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"u", "d", ""})
    void invalidMovingInputTest(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputValidator.validateInput(input));
    }

    @DisplayName("올바른 이동할 칸을 입력 받으면 예외가 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void validMovingInputTest(String input) {
        assertThatNoException()
                .isThrownBy(() -> inputValidator.validateInput(input));
    }
}