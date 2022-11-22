package bridge.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("다리의 길이가 숫자가 아니라면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"qwe", "123qw", " ", "", "123`", "223 ", "[pqwl;el"})
    void validateBridgeSizeTest_1(String input) {
        assertThatThrownBy(() -> InputValidator.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("다리의 길이가 3 미만 20 초과이면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"2", "0", "-3", "21", "-20", "103928", "-123323"})
    void validateBridgeSizeTest_2(String input) {
        assertThatThrownBy(() -> InputValidator.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("다리의 길이가 3 이상 20 이하라면 해당 길이 반환")
    @ParameterizedTest
    @ValueSource(strings = {"3", "20", "5", "18", "15", "19"})
    void validateBridgeSizeTest_3(String input) {
        assertThat(InputValidator.validateBridgeSize(input)).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("사용자가 이동할 칸이 U, D 가 아니라면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "UU", "DD", "UD", "DU", "U ", "D  ", " D", "u", "d", "wiiajd", "[23p1qwoek"})
    void validateMovingTest_1(String input) {
        assertThatThrownBy(() -> InputValidator.validateMoving(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("사용자가 이동할 칸이 U, D 라면 해당 방향 반환")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void validateMovingTest_2(String input) {
        assertThat(InputValidator.validateMoving(input)).isEqualTo(input);
    }

    @DisplayName("게임 재시작/종료 여부가 R, Q 가 아니라면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "RR", "QQ", "RQ", "QR", "R ", "Q  ", " R", "r", "q", "wiiajd", "[23p1qwoek"})
    void validateGameCommandTest_1(String input) {
        assertThatThrownBy(() -> InputValidator.validateGameCommand(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("게임 재시작/종료 여부가 R, Q 라면 해당 여부 반환")
    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    void validateGameCommandTest_2(String input) {
        assertThat(InputValidator.validateGameCommand(input)).isEqualTo(input);
    }
}
