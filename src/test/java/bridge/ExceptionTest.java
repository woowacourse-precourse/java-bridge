package bridge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionTest {
    @Test
    void 숫자입력_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> Exception.isNum("45a"));
    }

    @Test
    void onlyUorD() {
        assertThrows(IllegalArgumentException.class, () -> Exception.isUorD("a"));
        assertThrows(IllegalArgumentException.class, () -> Exception.isUorD("1"));
        Exception.isUorD("U");
        Exception.isUorD("D");
    }
}