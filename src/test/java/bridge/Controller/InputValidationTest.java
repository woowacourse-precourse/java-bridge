package bridge.Controller;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidationTest {
    private final InputValidation inputValidationTest = new InputValidation();
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("validateMove_실패_테스트")
    @ParameterizedTest
    @ValueSource(strings = {"u", "d", "1", "2", "Q", "R"})
    void validateMove_Fail(String input) {
        assertThatThrownBy(() -> {
            inputValidationTest.validateMove(input);
        }).hasMessageContaining(ERROR_MESSAGE)
          .isInstanceOf(IllegalArgumentException.class);
        System.out.println("실패 값 : " + input);
    }

    @DisplayName("validateMove_성공_테스트")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void validateMove_Success(String input) {
        inputValidationTest.validateMove(input);
        System.out.println("성공 값 : " + input);
    }

    @DisplayName("validateCommand_실패_테스트")
    @ParameterizedTest
    @ValueSource(strings = {"q", "r", "1", "2", "U", "D"})
    void validateCommand_Fail(String input) {
        assertThatThrownBy(() -> {
            inputValidationTest.validateCommand(input);
        }).hasMessageContaining(ERROR_MESSAGE)
          .isInstanceOf(IllegalArgumentException.class);
        System.out.println("실패 값 : " + input);
    }

    @DisplayName("validateCommand_성공_테스트")
    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    void validateCommand_Success(String input) {
        inputValidationTest.validateCommand(input);
        System.out.println("성공 값 : " + input);
    }

}