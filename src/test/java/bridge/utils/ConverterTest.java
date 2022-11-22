package bridge.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConverterTest {

    @Test
    void TRUE를_O로_변환() {
        boolean isAnswer = true;
        assertEquals(Converter.convertToOX(isAnswer), "O");
    }

    @Test
    void FALSE를_X로_변환() {
        boolean isAnswer = false;
        assertEquals(Converter.convertToOX(isAnswer), "X");
    }

    @Test
    void U를_입력받아_0으로_변환() {
        String command = "U";
        assertEquals(Converter.convertToIndex(command), 0);
    }

    @Test
    void D를_입력받아_1로_변환() {
        String command = "D";
        assertEquals(Converter.convertToIndex(command), 1);
    }
}