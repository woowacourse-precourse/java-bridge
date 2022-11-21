import static bridge.util.Constants.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.view.InputValidator;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputExceptionTest {
    @Nested
    class EmptyInput {
        final ThrowingCallable readBridgeSize = () -> InputValidator.bridgeSize("");
        final ThrowingCallable readMoving = () -> InputValidator.moving("");
        final ThrowingCallable readGameCommand = () -> InputValidator.gameCommand("");

        void throwingCallableTest(ThrowingCallable throwingCallable) {
            assertThatThrownBy(throwingCallable)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_TITLE + EMPTY_INPUT);
        }

        @DisplayName("입력값을 요구하는 메소드에 대해 아무 것도 입력하지 않으면 예외가 발생한다.")
        @Test
        void noInputException() {
            throwingCallableTest(readBridgeSize);
            throwingCallableTest(readMoving);
            throwingCallableTest(readGameCommand);
        }
    }

    @Nested
    class BridgeSize {

        @DisplayName("다리 길이 입력 시 숫자 외의 값이 들어가 있으면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"one", "둘", "8teen", "7곱"})
        void nonDigitInputException(String input) {
            assertThatThrownBy(() -> InputValidator.bridgeSize(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_TITLE + NON_DIGIT_CHARACTER_FOUND);
        }

        @DisplayName("다리 길이 입력 시 3 ~ 20 사이의 숫자가 아닌 값을 입력하면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"1", "0", "21", "2"})
        void InputOutOfRangeException(String input) {
            assertThatThrownBy(() -> InputValidator.bridgeSize(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_TITLE + BRIDGE_SIZE_FORMAT);
        }
    }

    @Nested
    class Moving {

        @DisplayName("이동할 칸 입력 시 알파벳 외의 값이 들어가 있으면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"위", "d0wn", "올라up", "u!"})
        void nonAlphabeticInputException(String input) {
            assertThatThrownBy(() -> InputValidator.moving(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_TITLE + NON_ALPHABETIC_CHARACTER_FOUND);
        }

        @DisplayName("이동할 칸 입력 시 U 또는 D를 입력하지 않으면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"r", "l", "up", "down"})
        void noUpOrDownException(String input) {
            assertThatThrownBy(() -> InputValidator.moving(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_TITLE + MOVING_FORMAT);
        }
    }

    @Nested
    class GameCommand {

        @DisplayName("게임 재개 여부 입력 시 알파벳 외의 값이 들어가 있으면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"가즈아", "야메로", "I'm 던", "q!"})
        void nonAlphabeticInputException2(String input) {
            assertThatThrownBy(() -> InputValidator.gameCommand(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_TITLE + NON_ALPHABETIC_CHARACTER_FOUND);
        }

        @DisplayName("게임 재개 여부 입력 시 R 또는 Q를 입력하지 않으면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"retry", "exit", "e", "qq"})
        void noUpOrDownException2(String input) {
            assertThatThrownBy(() -> InputValidator.gameCommand(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_TITLE + COMMAND_FORMAT);
        }
    }
}
