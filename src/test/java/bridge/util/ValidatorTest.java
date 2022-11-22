package bridge.util;

import bridge.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    private static final Validator validator = new Validator();

    @ParameterizedTest
    @ValueSource(strings = {"", "123"})
    @DisplayName("다리 길이 입력 크기가 1보다 작거나 2보다 큰 경우 예외 처리")
    void validateBridgeLength(String input) {
        assertThatThrownBy(() -> validator.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INCORRECT_BRIDGE_SIZE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1a", ";"})
    @DisplayName("숫자가 아닌 경우 예외 처리")
    void validateBridgeDigit(String input) {
        assertThatThrownBy(() -> validator.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INCORRECT_BRIDGE_SIZE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "21"})
    @DisplayName("3보다 작거나 20보다 큰 경우 예외 처리")
    void validateBridgeRange(String input) {
        assertThatThrownBy(() -> validator.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INCORRECT_BRIDGE_SIZE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"UD", "R"})
    @DisplayName("올바른 방향(U, D)이 아닌 경우 예외 처리")
    void validateMoving(String input) {
        assertThatThrownBy(() -> validator.validateMoving(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INCORRECT_MOVING);
    }

    @ParameterizedTest
    @ValueSource(strings = {"QR", "D"})
    @DisplayName("올바른 커맨드(R, Q)가 아닌 경우 예외 처리")
    void validateGameCommand(String input) {
        assertThatThrownBy(() -> validator.validateGameCommand(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INCORRECT_GAME_COMMAND);
    }
}