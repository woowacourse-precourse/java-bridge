package bridge.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputHandlerTest {
    @DisplayName("공통 예외 - 사용자 입력이 비어있는 경우, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = "")
    void handleEmptyInputExceptionTest(String input) {
        assertThatThrownBy(() -> {
            InputExceptionHandler.handleEmptyInputException(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("공통 예외 - 사용자 입력이 숫자 혹은 알파벳이 아닌 경우, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"@!#", " "})
    void handleNotNumberOrAlphabetExceptionTest(String input) {
        assertThatThrownBy(() -> {
            InputExceptionHandler.handleNotNumberOrAlphabetException(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("다리길이 예외 - 사용자 입력이 숫자가 아닌 경우, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "ABC"})
    void handleNotNumberExceptionTest(String input) {
        assertThatThrownBy(() -> {
            InputExceptionHandler.handleNotNumberException(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("이동 및 재시작 예외 - 사용자 입력이 대문자 알파벳이 아닌 경우, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"123", "abc"})
    void handleNotUpperAlphabetExceptionTest(String input) {
        assertThatThrownBy(() -> {
            InputExceptionHandler.handleNotUpperAlphabetException(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

}
