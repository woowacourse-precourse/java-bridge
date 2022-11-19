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
}