package bridge.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputParserTest {

    @ValueSource(strings = {"123j", "210591993939291"})
    @ParameterizedTest
    void throwErrorWhenInputIsNotInteger(String line) {
        Assertions.assertThatThrownBy(() -> InputParser.parseToInteger(line))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @CsvSource(value = {"123:123", "345:345"}, delimiter = ':')
    @ParameterizedTest
    void returnResultWhenInputIsInteger(String line, int answer) {
        Assertions.assertThat(InputParser.parseToInteger(line)).isEqualTo(answer);
    }
}