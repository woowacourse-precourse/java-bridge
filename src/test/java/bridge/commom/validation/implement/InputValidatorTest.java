package bridge.commom.validation.implement;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @DisplayName("다리의 사이즈를 알기위해서, 사용자의 입력을 받을 때 양의 정수가 아니라면 예외를 발생한다.")
    @ParameterizedTest(name = "양의 정수 유효성 검사 테스트[{index}] => {0}은 양의 정수가 아니다.  ")
    @ValueSource(strings = {"3.14", "0", "-1", "-2", "65.123", "-0.1", "abc", "양의 정수"})
    void ifInputValueInReadSizeIsNotPositiveIntegerThenThrowException(String actual) {
        assertThatThrownBy(() -> InputValidator.isPositiveInteger(actual))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양의 정수만 입력할 수 있습니다.");
    }

}