package bridge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrossResultTest {

    @Test
    void findCrossResult() {
        MoveResult moveResult = new MoveResult("U", false);

        assertEquals(CrossResult.FAIL, CrossResult.findCrossResult(moveResult.isMatchResult()));
    }

    @Test
    void successFailureLetter() {
        MoveResult moveResult = new MoveResult("D", false);

        assertEquals("X", CrossResult.successFailureLetter(moveResult.isMatchResult()));
    }
}