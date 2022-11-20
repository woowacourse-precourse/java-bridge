import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.view.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputExceptionTest {
//    private static final int MINIMUM_BRIDGE_SIZE = 3;
//    private static final int MAXIMUM_BRIDGE_SIZE = 20;
//
//    @DisplayName("다리 길이 입력 시 아무 것도 입력하지 않으면 예외가 발생한다.")
//    @Test
//    void noInputException() {
//        assertThatThrownBy(() -> InputValidator.bridgeSize(""))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("[ERROR] 입력된 값이 없습니다.");
//    }
//
//    @DisplayName("다리 길이 입력 시 숫자 형태가 아닌 값이 들어가 있으면 예외가 발생한다.")
//    @ParameterizedTest
//    @ValueSource(strings = {"one", "둘", "8teen", "7곱"})
//    void nonDigitInputException(String input) {
//        assertThatThrownBy(() -> InputValidator.bridgeSize(input))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("[ERROR] 다리 길이는 오직 숫자 형태만 받을 수 있습니다.");
//    }
//
//    @DisplayName("다리 길이 입력 시 3 ~ 20 사이의 숫자가 아닌 값을 입력하면 예외가 발생한다.")
//    @ParameterizedTest
//    @ValueSource(strings = {"1", "0", "21", "2"})
//    void InputOutOfRangeException(String input) {
//        assertThatThrownBy(() -> InputValidator.bridgeSize(input))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining(String.format(
//                        "[ERROR] 다리 길이는 %d부터 %d 사이의 숫자여야 합니다.",
//                        MINIMUM_BRIDGE_SIZE,
//                        MAXIMUM_BRIDGE_SIZE
//                ));
//    }
//
//    @DisplayName("이동할 칸 입력 시 아무 것도 입력하지 않으면 예외가 발생한다.")
//    @Test
//    void noInputException2() {
//        assertThatThrownBy(() -> InputValidator.moving(""))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("[ERROR] 입력된 값이 없습니다.");
//    }
//
//    @DisplayName("이동할 칸 입력 시 알파벳 형태가 아닌 값이 들어가 있으면 예외가 발생한다.")
//    @ParameterizedTest
//    @ValueSource(strings = {"위", "d0wn", "올라up", "u!"})
//    void nonAlphabeticInputException(String input) {
//        assertThatThrownBy(() -> InputValidator.moving(input))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("[ERROR] 오직 알파벳 형태만 입력할 수 있습니다.");
//    }
//
//    @DisplayName("이동할 칸 입력 시 \"U\" 또는 \"D\"와 일치하지 않으면 예외가 발생한다.")
//    @ParameterizedTest
//    @ValueSource(strings = {"r", "l", "up", "down"})
//    void noUpOrDownException(String input) {
//        assertThatThrownBy(() -> InputValidator.moving(input))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("[ERROR] 이동할 칸은 \"U\" 또는 \"D\"로 입력되어야 합니다.");
//    }
//
//    @DisplayName("게임 재개 여부 입력 시 아무 것도 입력하지 않으면 예외가 발생한다.")
//    @Test
//    void noInputException3() {
//        assertThatThrownBy(() -> InputValidator.gameCommand(""))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("[ERROR] 입력된 값이 없습니다.");
//    }
//
//    @DisplayName("게임 재개 여부 입력 시 알파벳 형태가 아닌 값이 들어가 있으면 예외가 발생한다.")
//    @ParameterizedTest
//    @ValueSource(strings = {"가즈아", "야메로", "I'm 던", "q!"})
//    void nonAlphabeticInputException2(String input) {
//        assertThatThrownBy(() -> InputValidator.gameCommand(input))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("[ERROR] 오직 알파벳 형태만 입력할 수 있습니다.");
//    }
//
//    @DisplayName("게임 재개 여부 입력 시 \"R\" 또는 \"Q\"와 일치하지 않으면 예외가 발생한다.")
//    @ParameterizedTest
//    @ValueSource(strings = {"retry", "exit", "e", "qq"})
//    void noUpOrDownException2(String input) {
//        assertThatThrownBy(() -> InputValidator.gameCommand(input))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("[ERROR] 게임 재개 여부는 \"R\" 또는 \"Q\"만 입력할 수 있습니다.");
//    }
}
