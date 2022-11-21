package bridge.convertor;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputConvertorTest {
    @DisplayName("숫자가 아닌 값이면 IllegalArgumentException이 발생한다.")
    @ValueSource(strings = {"#", "A", "b"})
    @ParameterizedTest
    void conversionTest(String input) {
        assertThatThrownBy(() -> InputConvertor.inputParseNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}