package bridge.model;

import static bridge.model.InputValidator.ERROR_INPUT_ABOUT_BRIDGE_SIZE;
import static bridge.model.InputValidator.ERROR_INPUT_ABOUT_MOVING;
import static bridge.model.InputValidator.ERROR_INPUT_ABOUT_RETRY;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    private InputValidator inputValidator;

    @BeforeEach
    void setInputValidator() {
        inputValidator = new InputValidator();
    }

    @DisplayName("잘못된 사이즈 입력시 예외발생")
    @ValueSource(strings = {"2", "", "21", "''", "$", "a"})
    @ParameterizedTest

    void input_false_size(String inputSize) {
        assertThatThrownBy(() -> inputValidator.isValidSize(inputSize)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ERROR_INPUT_ABOUT_BRIDGE_SIZE);
    }

    @DisplayName("정확한 사이즈 입력시 정상 작동")
    @ValueSource(strings = {"3", "20", "12"})
    @ParameterizedTest
    void input_true_size(String inputSize) {
        assertThatCode(() -> inputValidator.isValidSize(inputSize)).doesNotThrowAnyException();
    }

    @DisplayName("잘못된 이동위치 입력시 예외발생")
    @ValueSource(strings = {"", "E", "123", "%", "''"})
    @ParameterizedTest
    void input_false_moving(String moving) {
        assertThatThrownBy(() -> inputValidator.isValidMoving(moving)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ERROR_INPUT_ABOUT_MOVING);
    }

    @DisplayName("정확한 이동위치 입력시 정상 작동")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void input_true_moving(String moving) {
        assertThatCode(() -> inputValidator.isValidMoving(moving)).doesNotThrowAnyException();
    }

    @DisplayName("잘못된 게임 다시시작 문자 입력시 예외발생")
    @ValueSource(strings = {"", "32", "''", "A", "r"})
    @ParameterizedTest
    void input_false_retry(String retry) {
        assertThatThrownBy(() -> inputValidator.isValidRetry(retry)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ERROR_INPUT_ABOUT_RETRY);
    }

    @DisplayName("정확한 게임 다시시작 문자 입력시 정상 작동")
    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void input_true_retry(String retry) {
        assertThatCode(() -> inputValidator.isValidRetry(retry)).doesNotThrowAnyException();
    }
}
