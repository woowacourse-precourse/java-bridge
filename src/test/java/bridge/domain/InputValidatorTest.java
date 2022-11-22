package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {
    private final InputValidator testInputValidator = new InputValidator();

    @DisplayName("입력값이 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void inputBridgeSizeNotNumber() {
        assertThatThrownBy(() -> testInputValidator.validateBridgeSize("a"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 숫자만 입력해야 합니다.");
    }

    @DisplayName("입력값이 3부터 20 사이의 숫자가 아닌 경우 예외가 발생한다.")
    @ValueSource(strings = {"-10", "2", "21", "100"})
    @ParameterizedTest
    void inputBridgeSizeNotInRange(String input) {
        assertThatThrownBy(() -> testInputValidator.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    @DisplayName("입력값이 3부터 20 사이의 숫자인 경우 예외가 발생하지 않는다")
    @Test
    void inputBridgeSizeAppropriate() {
        assertThatNoException().isThrownBy(() -> testInputValidator.validateBridgeSize("10"));
    }

    @DisplayName("입력값이 U, D 중 하나가 아닌 경우 예외가 발생한다")
    @Test
    void inputMovingNotMove() {
        assertThatThrownBy(() -> testInputValidator.validateMoving("a"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] U, D 중 하나를 입력해야 합니다.");
    }

    @DisplayName("입력값이 U, D 중 하나인 경우 예외가 발생하지 않는다")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void inputMovingAppropriate(String input) {
        assertThatNoException().isThrownBy(() -> testInputValidator.validateMoving(input));
    }

    @DisplayName("입력값이 R, Q 중 하나가 아닌 경우 예외가 발생한다")
    @Test
    void inputGameCommandNotRQ() {
        assertThatThrownBy(() -> testInputValidator.validateGameCommand("a"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] R, Q 중 하나를 입력해야 합니다.");
    }

    @DisplayName("입력값이 R, Q 중 하나인 경우 예외가 발생하지 않는다")
    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void inputGameCommandAppropriate(String input) {
        assertThatNoException().isThrownBy(() -> testInputValidator.validateGameCommand(input));
    }
}
