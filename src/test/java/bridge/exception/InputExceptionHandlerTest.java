package bridge.exception;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputExceptionHandlerTest {

    @ParameterizedTest
    @DisplayName("다리 길이 생성 중 3~20의 올바른 숫자로 입력")
    @ValueSource(strings = {"3", "5", "9"})
    void checkBridgeSizeForm(String input) {
        assertThatCode(
                () -> InputExceptionHandler.checkBridgeSize(input)
        ).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("다리 길이 생성 중 3~20 숫자가 아닌 입력하였을 때 오류 확인")
    @ValueSource(strings = {"1", "21", "a", "@@"})
    void checkBridgeSizeFormFailureWhenNotRangeOrNotNumeric(String input) {
        assertThatThrownBy(
                () -> InputExceptionHandler.checkBridgeSize(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("이동 칸 입력 중 올바른 값인 U와 D로 입력")
    @ValueSource(strings = {"U", "D"})
    void checkMovingCommand(String input) {
        assertThatCode(
                () -> InputExceptionHandler.checkMovingCommand(input)
        ).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("이동 칸 입력 중 U와 D가 아닌 값으로 입력하였을 때 오류 확인")
    @ValueSource(strings = {"@9", "Say", "Good", "Bye", "!"})
    void checkMovingCommandFailureWhenNotMovingCommand(String input) {
        assertThatThrownBy(
                () -> InputExceptionHandler.checkMovingCommand(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("재시도 입력 중 올바른 값인 Q 또는 R로 입력")
    @ValueSource(strings = {"Q", "R"})
    void checkRetryCommand(String input) {
        assertThatCode(
                () -> InputExceptionHandler.checkRetryCommand(input)
        ).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("재시도 입력 중 Q 와 R이 아닌 값으로 입력하였을 때 오류 확인")
    @ValueSource(strings = {"D", "U", "q", "r"})
    void checkRetryCommandFailureWhenNotRetryCommand(String input) {
        assertThatThrownBy(
                () -> InputExceptionHandler.checkRetryCommand(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}