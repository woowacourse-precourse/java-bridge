package bridge;

import bridge.Input.InputValidation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidationTest {
    InputValidation inputValidation;

    @BeforeEach
    void setting() {
        inputValidation = new InputValidation();
    }

    @DisplayName("다리 길이 3 ~ 20가 아닐 시 예외 발생")
    @ValueSource(strings = {"1", "2", "21", "-3", "1000", "test"})
    @ParameterizedTest
    void validateBridgeSizeTest(String bridgeSizeInput) {
        Assertions.assertThatThrownBy(() -> inputValidation.validateBridgeSize(bridgeSizeInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 이동 U, D가 아닐 시 예외 발생")
    @ValueSource(strings = {"R", "Q", "T", "UU", "1000", "test"})
    @ParameterizedTest
    void validateMoveCommandTest(String moveCommand) {
        Assertions.assertThatThrownBy(() -> inputValidation.validateMoveCommand(moveCommand))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 끝났을 때 R, Q가 아닐 시 예외 발생")
    @ValueSource(strings = {"U", "D", "T", "RR", "1000", "test"})
    @ParameterizedTest
    void validateGameCommandTest(String gameCommand) {
        Assertions.assertThatThrownBy(() -> inputValidation.validateGameCommand(gameCommand))
                .isInstanceOf(IllegalArgumentException.class);
    }



}
