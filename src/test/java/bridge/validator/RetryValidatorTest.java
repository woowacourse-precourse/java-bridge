package bridge.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RetryValidatorTest {
    RetryValidator validator;

    @BeforeEach
    void setUp() {
        validator = new RetryValidator();
    }

    @DisplayName("입력 값이 Q나 R이면 정상 작동 한다.")
    @ValueSource(strings = {"Q", "R"})
    @ParameterizedTest
    void retryValidationTest(String input) {
        // given
        String result = input;

        // when
        String test = validator.retryValidator(input);

        // then
        assertThat(test)
                .isEqualTo(result);
    }

    @DisplayName("입력 값이 R이나 Q가 아닌 값이면 에러가 발생한다.")
    @ValueSource(strings = {"A", "W", "E", "#", "1", "-", "+", "QQ", "RR"})
    @ParameterizedTest
    void retryValidationTest_error(String input) {
        assertThatThrownBy(() -> validator.retryValidator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}