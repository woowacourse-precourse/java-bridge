package bridge.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static bridge.message.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidateTest {

    @DisplayName("숫자 이외의 문자가 입력되면 예외가 발생")
    @ParameterizedTest
    @ValueSource(strings = {"10a", "20.", " 5", "a"})
    void digitTypeValidate(String input) {
        assertThatThrownBy(() ->
                Validate.digitTypeValidate(input)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TYPE_EXCEPTION);
    }

    @DisplayName("입력받은 숫자가 3 이상 20 이하의 숫자가 아니라면 예외가 발생")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "100", "2"})
    void numberRangeValidate(int number) {
        assertThatThrownBy(() ->
                Validate.numberRangeValidate(number)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(OUT_OF_RANGE_EXCEPTION);
    }

    @DisplayName("U(위 칸), D(아래 칸) 이외의 문자가 입력되면 예외가 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1", "A", "UU", "DD", "U ", "D ", "."})
    void directionValidate(String direction) {
        assertThatThrownBy(() ->
                Validate.directionValidate(direction)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DIRECTION_EXCEPTION);
    }

    @DisplayName("R(재시작), Q(종료) 이외의 문자가 입력되면 예외가 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1", "A", "RR", "QQ", "R ", "Q ", ".", "r", "q"})
    void commandValidate(String command) {
        assertThatThrownBy(() ->
                Validate.commandValidate(command)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(COMMAND_EXCEPTION);
    }
}