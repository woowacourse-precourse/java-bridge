package bridge.validation;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeSizeValidationTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    private BridgeSizeValidation validation;

    @BeforeEach
    void beforeEach() {
        validation = new BridgeSizeValidation();
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
    void isBlankTest(String bridgeSize) {
        // when, then
        assertThatThrownBy(() -> validation.isBlank(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("숫자가 아닌 값을 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"삼", "three", "이십", "twenty", "lO", "1오"})
    void isNumberTest(String bridgeSize) {
        // when, then
        assertThatThrownBy(() -> validation.isNumber(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("입력이 3부터 20사이의 숫자가 아닌 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2", "21", "22", "100", "-3", "-20"})
    void isCorrectRangeTest(String bridgeSize) {
        // when, then
        assertThatThrownBy(() -> validation.isCorrectRange(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("총 유효성 테스트 : 입력이 올바른 경우")
    @ParameterizedTest
    @ValueSource(strings = {"3", "4", "5", "10", "15", "19", "20"})
    void correctTest(String bridgeSize) {
        // when, then
        assertThatNoException().isThrownBy(() -> validation.totalValidate(bridgeSize));
    }

    @DisplayName("총 유효성 테스트 : 입력이 틀린 경우")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2", "21", "twenty", "2o", "삼", "three"})
    void inCorrectTest(String bridgeSize) {
        // when, then
        assertThatThrownBy(() -> validation.totalValidate(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}