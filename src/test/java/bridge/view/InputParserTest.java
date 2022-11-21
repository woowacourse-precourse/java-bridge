package bridge.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class InputParserTest {

    @DisplayName("숫자 파싱")
    @Nested
    class ParseNumberTest {

        @DisplayName("숫자가 아닌 문자가 들어가면 예외를 던저야 한다.")
        @Test
        void nonNumber() {
            InputParser inputParser = new InputParser();

            String nonNumber = "A";

            assertThatThrownBy(() -> inputParser.parseNumber(nonNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("숫자를 입력해주세요");
        }

        @DisplayName("숫자인 문자가 들어가면 파싱을 해야 한다.")
        @Test
        void number() {
            InputParser inputParser = new InputParser();
            String number = "12";

            int numberInt = inputParser.parseNumber(number);

            assertThat(numberInt).isEqualTo(12);
        }
    }
}