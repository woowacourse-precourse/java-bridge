import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.util.CommandKeys;
import bridge.view.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputExceptionTest {
    @DisplayName("다리 길이 입력 시 아무 것도 입력하지 않으면 예외가 발생한다.")
    @Test
    void noInputException() {
        assertThatThrownBy(() -> InputValidator.bridgeSize(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력된 값이 없습니다.");
    }

    @DisplayName("다리 길이 입력 시 숫자 외의 값이 들어가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"one", "둘", "8teen", "7곱"})
    void nonDigitInputException(String input) {
        assertThatThrownBy(() -> InputValidator.bridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자 외의 값이 입력되었습니다.");
    }

    @DisplayName("다리 길이 입력 시 3 ~ 20 사이의 숫자가 아닌 값을 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "0", "21", "2"})
    void InputOutOfRangeException(String input) {
        assertThatThrownBy(() -> InputValidator.bridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    @DisplayName("이동할 칸 입력 시 아무 것도 입력하지 않으면 예외가 발생한다.")
    @Test
    void noInputException2() {
        assertThatThrownBy(() -> InputValidator.moving(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력된 값이 없습니다.");
    }

    @DisplayName("이동할 칸 입력 시 알파벳 형태가 아닌 값이 들어가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"위", "d0wn", "올라up", "u!"})
    void nonAlphabeticInputException(String input) {
        assertThatThrownBy(() -> InputValidator.moving(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 알파벳 외의 값이 입력되었습니다.");
    }

    @DisplayName("이동할 칸 입력 시 \"U\" 또는 \"D\"와 일치하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"r", "l", "up", "down"})
    void noUpOrDownException(String input) {
        assertThatThrownBy(() -> InputValidator.moving(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 다음 칸으로 이동하기 위해선 U 또는 D를 입력해야 합니다.");
    }

    @DisplayName("게임 재개 여부 입력 시 아무 것도 입력하지 않으면 예외가 발생한다.")
    @Test
    void noInputException3() {
        assertThatThrownBy(() -> InputValidator.gameCommand(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력된 값이 없습니다.");
    }

    @DisplayName("게임 재개 여부 입력 시 알파벳 형태가 아닌 값이 들어가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"가즈아", "야메로", "I'm 던", "q!"})
    void nonAlphabeticInputException2(String input) {
        assertThatThrownBy(() -> InputValidator.gameCommand(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 알파벳 외의 값이 입력되었습니다.");
    }

    @DisplayName("게임 재개 여부 입력 시 R 또는 Q와 일치하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"retry", "exit", "e", "qq"})
    void noUpOrDownException2(String input) {
        assertThatThrownBy(() -> InputValidator.gameCommand(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 게임 재개 여부를 정하기 위해선 R 또는 Q를 입력해야 합니다.");
    }
}
