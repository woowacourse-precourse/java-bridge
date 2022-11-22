package bridge.command;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LocationCommandTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("입력값이 1이면 U를 반환하고 입력값이 0이면 D를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:U", "0:D"}, delimiter = ':')
    void inputRandomNum1Or0ReturnUOrD(int input, String output) {
        assertThat(LocationCommand.decideLocationToCross(input)).isEqualTo(output);
    }

    @DisplayName("입력값이 1과 0이외의 값이 들어오면 에러를 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 2, 4, 120, Integer.MAX_VALUE})
    void inputWrongNumber(int input) {
        assertThatThrownBy(() -> LocationCommand.decideLocationToCross(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }
}