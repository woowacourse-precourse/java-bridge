package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapTypeTest {

    @DisplayName("TRUE 전달 시 O 문자열 반환")
    @Test
    void getOByTrue() {
        String mark = MapType.getMarkByBoolean(true);
        assertEquals(mark, "O");
    }

    @DisplayName("FALSE 전달 시 X 문자열 반환")
    @Test
    void getXByFalse() {
        String mark = MapType.getMarkByBoolean(false);
        assertEquals(mark, "X");
    }

    @DisplayName("NULL 전달 시 공백 문자열 반환")
    @Test
    void getBlankByNull() {
        String mark = MapType.getMarkByBoolean(null);
        assertEquals(mark, " ");
    }
}