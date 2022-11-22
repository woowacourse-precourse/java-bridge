package bridge;

import bridge.controller.InputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @ParameterizedTest
    @DisplayName("범위를 벗어나는 다리 길이 입력 시 예외 발생하는지 테스트")
    @ValueSource(ints = {2, 1, 0, -1, -2, 30, 45, 21, 1000000})
    void validateBridgeSize_OutOfSizeRange_ExceptionThrown(int size) {
        assertThatThrownBy(() -> inputValidator.validateBridgeSizeRange(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("다리 길이 입력 시 문자가 포함되었을 때 예외가 발생하는지 테스트")
    @ValueSource(strings = {"11a", "11 ", "300\\", "20;", "4csb7", "", " "})
    void validateBridgeSize_InclusiveString_ExceptionThrown(String input) {
        assertThatThrownBy(() -> inputValidator.validatePureNumber(input))
                .isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest
    @DisplayName("이동할 칸 입력 시 정해진 문자 외 다른 문자가 포함되었을 때 예외가 발생하는지 테스트")
    @ValueSource(strings = {"R", "u", "q", "Q", "123", "a", "B", "coding", "joa", "s ", " "})
    void validateMoving_InValidInput_ExceptionThrown(String input) {
        assertThatThrownBy(() -> inputValidator.validateMoving(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("재시작여부 입력 시 정해진 문자 외 다른 문자가 포함되었을 때 예외가 발생하는지 테스트")
    @ValueSource(strings = {"U", "r", "D", "d","coding", "joa", "s ", " "})
    void validateRestart_InValidInput_ExceptionThrown(String input) {
        assertThatThrownBy(() -> inputValidator.validateRestart(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}