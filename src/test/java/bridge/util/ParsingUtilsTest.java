package bridge.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParsingUtilsTest {
    @DisplayName("정수로 이루어진 문자열을 정수로 변환한다.")
    @Test
    void stringToInt() {
        String input = " 50";
        int number = 50;

        assertThat(ParsingUtils.stringToInt(input)).isEqualTo(number);
    }

    @DisplayName("정수가 아닌 문자열을 정수로 변환하면 예외가 발생한다.")
    @Test
    void stringToIntByNotInteger() {
        String input = "a1";

        assertThatThrownBy(() -> ParsingUtils.stringToInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}