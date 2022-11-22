package bridge.util;

import static bridge.util.TypeConversion.stringToInt;
import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TypeConversionTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "a"})
    void stringToIntByNotIntegerValue(String input) {
        Assertions.assertThatThrownBy(() -> stringToInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3"})
    void stringToIntByIntegerValue(String input) {
        // given
        int expected = 3;

        // when
        int result = stringToInt(input);

        // then
        assertThat(result).isEqualTo(expected);
    }
}