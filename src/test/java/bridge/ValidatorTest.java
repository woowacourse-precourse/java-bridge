package bridge;

import static bridge.view.Validator.validateInputDirectionException;
import static bridge.view.Validator.validateInputGameRestartException;
import static bridge.view.Validator.validateInputSizeException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class ValidatorTest {

    @DisplayName("3 이상 20 이하의 숫자가 아닐 시 예외 발생")
    @ValueSource(strings = {"1", "0", "-1", "21"})
    @ParameterizedTest
    void InputSizeTest(String input) {
        assertThatThrownBy(() -> validateInputSizeException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이 입력 값이 Null이면 예외 발생")
    @Test
    void InputSizeNullTest() {
        assertThatThrownBy(() -> validateInputSizeException(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이에 문자 입력시 예외 발생")
    @ValueSource(strings = {"1r", "g", "U", "Q"})
    @ParameterizedTest
    void InputSizeTypeTest(String input) {
        assertThatThrownBy(() -> validateInputSizeException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 이동 시 U,D 외의 문자 입력시 예외 발생")
    @ValueSource(strings = {"x", "1", "R", "Q"})
    @ParameterizedTest
    void InputDirectionTest(String input) {
        assertThatThrownBy(() -> validateInputDirectionException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("U, D를 소문자로 입력 시 예외 발생")
    @ValueSource(strings = {"u", "d"})
    @ParameterizedTest
    void InputDirectionLowerCaseTest(String input) {
        assertThatThrownBy(() -> validateInputDirectionException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동 입력 값이 Null이면 예외 발생")
    @Test
    void InputDirectionNullTest() {
        assertThatThrownBy(() -> validateInputDirectionException(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시작, 종료 시 R,Q 외의 문자 입력시 예외 발생")
    @ValueSource(strings = {"U", "D", "Z"})
    @ParameterizedTest
    void InputGameRestartTest(String input) {
        assertThatThrownBy(() -> validateInputGameRestartException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시작, 종료 값을 소문자로 입력 시 예외 발생")
    @Test
    void InputGameRestartLowerCaseTest() {

    }

    @DisplayName("재시작, 종료 값이 Null이면 예외 발생")
    @Test
    void InputGameRestartNullTest() {

    }
}
