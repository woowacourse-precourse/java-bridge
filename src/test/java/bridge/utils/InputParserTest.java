package bridge.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputParserTest {

    @DisplayName("int 범위의 정수가 아닌경우 오류를 반환한다.")
    @ValueSource(strings = {"123j", "210591993939291"})
    @ParameterizedTest
    void throwErrorWhenInputIsNotInteger(String line) {
        Assertions.assertThatThrownBy(() -> InputParser.parseToInteger(line))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("int 범위의 정수이면 적절한 값을 반환한다.")
    @CsvSource(value = {"123:123", "345:345"}, delimiter = ':')
    @ParameterizedTest
    void returnResultWhenInputIsInteger(String line, int answer) {
        Assertions.assertThat(InputParser.parseToInteger(line)).isEqualTo(answer);
    }
}