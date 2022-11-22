
package bridge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BridgeGameTest {
    @Test
    void 움직임이_가능한_경우() {
        BridgeGame bridgeGame = new BridgeGame();
        boolean move = bridgeGame.move("U", "U");
        assertTrue(move);
    }

    @Test
    void 움직임이_불가능한_경우() {
        BridgeGame bridgeGame = new BridgeGame();
        boolean move = bridgeGame.move("D", "U");
        assertFalse(move);
    }
}