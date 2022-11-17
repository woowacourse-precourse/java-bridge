package bridge.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumericConverterTest {

    @DisplayName("문자열을 숫자로 변환한다.")
    @Test
    void convert() {
        //given
        String from = "10";
        Converter<String, Integer> numericConverter = new NumericConverter();

        //when
        Integer to = numericConverter.convert(from);

        //then
        assertThat(to).isEqualTo(10);
    }

    @DisplayName("문자열을 숫자로 변환할 수 없으면 예외가 발생한다.")
    @Test
    void convertFail() {
        //given
        String from = "k10";
        Converter<String, Integer> numericConverter = new NumericConverter();

        //then
        assertThatThrownBy(() -> numericConverter.convert(from)).isInstanceOf(
                IllegalArgumentException.class);
    }

}