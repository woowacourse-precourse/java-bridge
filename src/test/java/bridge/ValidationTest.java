package bridge;

import static bridge.validation.ErrorMessage.ERROR_INVALID_BRIDGE_SIZE;
import static bridge.validation.ErrorMessage.ERROR_INVALID_GAME_COMMAND;
import static bridge.validation.ErrorMessage.ERROR_INVALID_MOVE_COMMAND;
import static bridge.validation.Validation.validateBridgeSize;
import static bridge.validation.Validation.validateGameCommand;
import static bridge.validation.Validation.validateMoveCommand;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidationTest {
    @ParameterizedTest
    @DisplayName("[ERROR] 적절하지 않은 값을 다리 사이즈로 입력시 예외 발생")
    @CsvSource({"1a2", "21", "2"})
    void invalidInputInBridgeSize(String userInput) {
        assertThatThrownBy(() -> validateBridgeSize(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_INVALID_BRIDGE_SIZE);
    }
    @Test
    @DisplayName("[ERROR] 다리 사이즈로 입력하지 않았을 때 예외 발생")
    void noInputInBridgeSize() {
        String userInput = "";
        assertThatThrownBy(() -> validateBridgeSize(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_INVALID_BRIDGE_SIZE);
    }

    @ParameterizedTest
    @DisplayName("[ERROR] U 또는 D 이외의 값 입력시 예외 발생")
    @CsvSource({"1U", "u", "A"})
    void invalidInputInMoveCommand(String userInput) {
        assertThatThrownBy(() -> validateMoveCommand(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_INVALID_MOVE_COMMAND);
    }

    @ParameterizedTest
    @DisplayName("[ERROR] R 또는 Q 이외의 값 입력시 예외 발생")
    @CsvSource({"1Q", "1R", "QQ", "RR"})
    void invalidInputInGameCommand(String userInput) {
        assertThatThrownBy(() -> validateGameCommand(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_INVALID_GAME_COMMAND);
    }


}