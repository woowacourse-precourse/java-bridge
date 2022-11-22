package bridge.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

    Converter converter = new Converter();

    @Test
    void convertToInt() {
        int result = converter.convertToInt("3");
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    void convertBooleanToString() {
        String successResult = converter.convertBooleanToString(true);
        Assertions.assertThat(successResult).isEqualTo("성공");

        String failResult = converter.convertBooleanToString(false);
        Assertions.assertThat(failResult).isEqualTo("실패");
    }
}