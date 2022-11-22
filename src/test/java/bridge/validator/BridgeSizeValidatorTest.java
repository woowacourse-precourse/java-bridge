package bridge.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeSizeValidatorTest {
    BridgeSizeValidator validator = new BridgeSizeValidator();

    @DisplayName("3~20 사이의 값이면 정상 동작한다.")
    @ValueSource(strings = {"3", "5", "10", "15", "20"})
    @ParameterizedTest
    void sizeValidationTest(String input) {
        // given
        String result = input;

        // when
        String test = validator.sizeValidator(input);

        // then
        assertThat(test)
                .isEqualTo(result);
    }

    @DisplayName("3~20 사이의 값이 아니면 에러가 발생한다.")
    @ValueSource(strings = {"-3", "1", "2", "21", "500"})
    @ParameterizedTest
    void sizeValidationTest_error(String input) {
        assertThatThrownBy(() -> validator.sizeValidator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}