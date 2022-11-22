package bridge;

import static bridge.util.Constants.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.util.InputValidator;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputExceptionTest {

    private static final String NO_SPACE = "";

    @Nested
    class EmptyInput {

        final ThrowingCallable validateBridgeSize = () -> InputValidator.bridgeSize(NO_SPACE);
        final ThrowingCallable validateMoving = () -> InputValidator.moving(NO_SPACE);
        final ThrowingCallable validateGameCommand = () -> InputValidator.gameCommand(NO_SPACE);

        void throwingCallableTest(ThrowingCallable throwingCallable) {
            assertThatThrownBy(throwingCallable)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.TITLE +
                            ErrorMessage.EMPTY_INPUT
                    );
        }

        @DisplayName("입력값을 요구하는 메소드에 대해 아무 것도 입력하지 않으면 예외가 발생한다.")
        @Test
        void noInputException() {
            throwingCallableTest(validateBridgeSize);
            throwingCallableTest(validateMoving);
            throwingCallableTest(validateGameCommand);
        }
    }

    @Nested
    class BridgeSize {

        @DisplayName("다리 길이 입력 시 숫자 외의 값이 들어가 있으면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"one", "둘", "8teen", "7곱", "!1"})
        void nonDigitInputException(String input) {
            assertThatThrownBy(() -> InputValidator.bridgeSize(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.TITLE +
                            ErrorMessage.NON_DIGIT_CHARACTER_FOUND);
        }

        @DisplayName("다리 길이 입력 시 3 ~ 20 사이의 숫자가 아닌 값을 입력하면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"1", "0", "21", "2"})
        void InputOutOfRangeException(String input) {
            assertThatThrownBy(() -> InputValidator.bridgeSize(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.TITLE +
                            ErrorMessage.BRIDGE_SIZE_FORMAT);
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
                    .hasMessageContaining(ErrorMessage.TITLE +
                            ErrorMessage.NON_ALPHABETIC_CHARACTER_FOUND
                    );
        }

        @DisplayName("이동할 칸 입력 시 U 또는 D를 입력하지 않으면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"r", "l", "up", "down"})
        void noUpOrDownException(String input) {
            assertThatThrownBy(() -> InputValidator.moving(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.TITLE +
                            ErrorMessage.MOVING_FORMAT);
        }
    }

    @Nested
    class GameCommand {

        @DisplayName("게임 재개 여부 입력 시 알파벳 외의 값이 들어가 있으면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"가즈ah", "야메로", "I'm 던", "q!"})
        void nonAlphabeticInputException2(String input) {
            assertThatThrownBy(() -> InputValidator.gameCommand(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.TITLE +
                            ErrorMessage.NON_ALPHABETIC_CHARACTER_FOUND);
        }

        @DisplayName("게임 재개 여부 입력 시 R 또는 Q를 입력하지 않으면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"retry", "exit", "e", "qq"})
        void noRetryOrQuitException(String input) {
            assertThatThrownBy(() -> InputValidator.gameCommand(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.TITLE +
                            ErrorMessage.COMMAND_FORMAT);
        }
    }
}
