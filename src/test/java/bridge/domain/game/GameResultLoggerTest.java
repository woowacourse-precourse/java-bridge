package bridge.domain.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameResultLoggerTest {

    private GameResultLogger result;

    @BeforeEach
    void setup() {
        result = new GameResultLogger();
    }
    @Test
    void testLogResult() {
        result.logResult("U", CrossResult.SUCCESS);
        result.logResult("D", CrossResult.SUCCESS);
        result.logResult("U", CrossResult.FAILURE);

        assertEquals(CrossResult.SUCCESS, result.getTopRoad().get(0));
        assertEquals(CrossResult.PASS, result.getTopRoad().get(1));
        assertEquals(CrossResult.FAILURE, result.getTopRoad().get(2));

        assertEquals(CrossResult.PASS, result.getDownRoad().get(0));
        assertEquals(CrossResult.SUCCESS, result.getDownRoad().get(1));
        assertEquals(CrossResult.PASS, result.getDownRoad().get(2));
    }

    @Test
    void testCountAttempts() {
        result.logResult("U", CrossResult.FAILURE);
        result.reset();
        assertEquals(2, result.getNumOfAttempts());
        result.reset();
        assertEquals(3, result.getNumOfAttempts());
    }
}