package bridge;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParserTest {

    @Nested
    @DisplayName("숫자 변환에")
    class In_numerical_conversion {

        @ParameterizedTest
        @ValueSource(strings = {"0", "1", "2"})
        @DisplayName("다음 숫자를 넣었을 때 정상적으로 파싱을 한다")
        void if_input_number_then_convert_normally(String input) {
            // when, then
            assertThatCode(() -> Parser.parseToInt(input))
                    .doesNotThrowAnyException();
        }

        @ParameterizedTest
        @ValueSource(strings = {"", " ", "test"})
        @DisplayName("다음 문자를 넣었을 경우")
        void when_input_string(String input) {
            // when, then
            assertThatThrownBy(() -> Parser.parseToInt(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INPUT_FORMAT_IS_INCORRECT.getMessage());
        }

    }
}
