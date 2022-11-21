package bridge.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MovingValidationTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    private MovingValidation validation;

    @BeforeEach
    void beforeEach() {
        validation = new MovingValidation();
    }

    @DisplayName("빈 문자열을 입력한 경우 테스트")
    @Test
    void isNullTest() {
        // when, then
        assertThatThrownBy(() -> validation.isNull(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("공백의 문자열을 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {" ", "       "})
    void isBlankTest(String moving) {
        // when, then
        assertThatThrownBy(() -> validation.isBlank(moving))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("대문자 U, D가 아닌 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"u", "d", "1", "0", "위", "아래", "!"})
    void isUpperCaseUDTest(String moving) {
        // when, then
        assertThatThrownBy(() -> validation.isUpperCaseUD(moving))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}