package bridge.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumericConverterTest {

    @DisplayName("문자열을 숫자로 변환한다.")
    @Test
    void convert() {
        //given
        String from = "10";

        //when
        Integer to = NumericConverter.convert(from);

        //then
        assertThat(to).isEqualTo(10);
    }

    @DisplayName("문자열을 숫자로 변환할 수 없으면 예외가 발생한다.")
    @ValueSource(strings = {"@", " ", "u", "가", "U"})
    @ParameterizedTest
    void convertFail(String from) {
        //then
        assertThatThrownBy(() -> NumericConverter.convert(from)).isInstanceOf(
                IllegalArgumentException.class);
    }

}