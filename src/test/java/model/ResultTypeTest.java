package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultTypeTest {

    @DisplayName("TRUE 전달 시 WIN 반환")
    @Test
    void getByTrue() {
        ResultType result = ResultType.getByBoolean(true);
        assertEquals(result, ResultType.WIN);
    }

    @DisplayName("FALSE 전달 시 LOSE 반환")
    @Test
    void getByFalse() {
        ResultType result = ResultType.getByBoolean(false);
        assertEquals(result, ResultType.LOSE);
    }
}