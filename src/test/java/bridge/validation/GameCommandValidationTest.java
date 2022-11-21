package bridge.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameCommandValidationTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    private GameCommandValidation validation;

    @BeforeEach
    void beforeEach() {
        validation = new GameCommandValidation();
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
    @ValueSource(strings = {" ", "     "})
    void isBlankTest(String gameCommand) {
        // when, then
        assertThatThrownBy(() -> validation.isBlank(gameCommand))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("대문자 R, Q가 아닌 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"r", "q", "알", "큐", "RQ", "QR", "!", "P"})
    void isUpperCaseUDTest(String gameCommand) {
        // when, then
        assertThatThrownBy(() -> validation.isUpperCaseRQ(gameCommand))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}