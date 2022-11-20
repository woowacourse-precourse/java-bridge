package bridge.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    @DisplayName("문자에서 숫자로 바뀌는지 확인")
    @Test
    void checkConvertInputToInt() {
        String input = "123";
        assertThatCode(() -> InputValidator.changeInputToInt(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("문자에서 숫자로 바꿀 수 없는 경우 예외 처리")
    @Test
    void checkConvertInputToIntByNoneDigit() {
        String input = "abc";
        assertThatThrownBy(() -> InputValidator.changeInputToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 정수형의 숫자가 아닙니다.");
    }

    @DisplayName("다리의 길이가 3~20의 숫자이면 정상 작동")
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 10, 15, 20})
    void validateBridgeSizeOfSuccessCase(int size) {
        assertThatCode(() -> InputValidator.validateBridgeSize(size))
                .doesNotThrowAnyException();
    }

    @DisplayName("다리의 길이가 3~20의 숫자가 아니면 예외 처리")
    @ParameterizedTest
    @ValueSource(ints = {0, 2, 21, 30})
    void validateBridgeSizeOfExceptionCase(int size) {
        assertThatThrownBy(() -> InputValidator.validateBridgeSize(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    @DisplayName("다음에 이동할 칸에 \"U\"나 \"D\"를 입력하면 정상 작동")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void validateNextMoveOfSuccessCase(String movement) {
        assertThatCode(() -> InputValidator.validateMovementInput(movement))
                .doesNotThrowAnyException();
    }

    @DisplayName("다음에 이동할 칸에 대한 입력이 \"U\"나 \"D\"가 아니면 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"A", "B", "C", "1"})
    void validateNextMoveOfExceptionCase(String movement) {
        assertThatThrownBy(() -> InputValidator.validateMovementInput(movement))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] \"U\"와 \"D\" 만 입력 가능합니다.");
    }

    @DisplayName("재시작에 대한 입력이 \"R\"이나 \"Q\"면 정상 작동")
    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    void validateRestartInputOfSuccessCase(String restartInput) {
        assertThatCode(() -> InputValidator.validateRestartInput(restartInput))
                .doesNotThrowAnyException();
    }

    @DisplayName("재시작에 대한 입력이 \"R\"이나 \"Q\"가 아니면 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"D", "U", "AB", "1"})
    void validateRestartInputOfExceptionCase(String restartInput) {
        assertThatThrownBy(() -> InputValidator.validateRestartInput(restartInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] \"R\"과 \"Q\" 만 입력 가능합니다.");
    }
}
