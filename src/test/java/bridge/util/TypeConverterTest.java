package bridge.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TypeConverterTest {

    @DisplayName("형변환 [문자열 -> 정수]")
    @Test
    void 문자열에서_정수로_형변환() {
        assertEquals(TypeConverter.stringToInt("1"), 1);
    }

    @DisplayName("형변환 [문자열 -> 문자]")
    @Test
    void 문자열에서_문자로_형변환() {
        assertEquals(TypeConverter.stringToChar("c"), 'c');
    }

    @DisplayName("입력받은 블럭(Up, Down)을 정수로 변환")
    @Test
    void 블럭에서_정수로_변환() {
        assertEquals(TypeConverter.blockToNumber("U"), 0);
    }
}