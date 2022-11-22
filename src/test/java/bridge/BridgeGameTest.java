package bridge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {
    BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        bridgeGame = new BridgeGame();
        bridgeGame.setBridge(List.of("U", "D", "U"));
    }

    @Test
    void testCreateResultMap() {
        testMove();
        assertEquals("[ O |   |   ]\n[   | O | X ]", bridgeGame.createResultMap());
    }

    @Test
    void testMove() {
        assertEquals(true, bridgeGame.move("U"));
        assertEquals(true, bridgeGame.move("D"));
        assertEquals(false, bridgeGame.move("D"));
    }

    @Test
    void testRetry() {
        bridgeGame.retry();
        assertEquals(2, bridgeGame.getTryNum());
    }

}
