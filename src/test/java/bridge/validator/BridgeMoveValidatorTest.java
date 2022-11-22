package bridge.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMoveValidatorTest {
    BridgeMoveValidator validator = new BridgeMoveValidator();

    @DisplayName("입력 값이 U나 D면 정상 작동 한다.")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void moveValidationTest(String input) {
        // given
        String result = input;

        // when
        String test = validator.moveValidator(input);

        // then
        assertThat(test)
                .isEqualTo(result);
    }

    @DisplayName("입력 값이 U나 D가 아닌 값이면 에러가 발생한다.")
    @ValueSource(strings = {"Q", "W", "E", "#", "1", "-", "+", "UU", "DD"})
    @ParameterizedTest
    void moveValidationTest_error(String input) {
        assertThatThrownBy(() -> validator.moveValidator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}