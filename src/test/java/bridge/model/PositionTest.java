package bridge.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PositionTest {
    @Test
    void 축약어_반환_테스트() {
        Assertions.assertEquals("D", Position.getAbbreviation(0));
        Assertions.assertEquals("U", Position.getAbbreviation(1));
    }

    @Test
    void Position_반환_테스트() {
        Assertions.assertEquals(Position.UP, Position.fromAbbreviation("U"));
        Assertions.assertEquals(Position.DOWN, Position.fromAbbreviation("D"));
    }

    @Test
    void 다이어그램_표기_테스트() {
        Assertions.assertTrue(Position.UP.isRightPlace(Position.UP));
        Assertions.assertFalse(Position.UP.isRightPlace(Position.DOWN));
    }
}