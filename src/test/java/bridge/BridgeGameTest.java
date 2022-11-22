
package bridge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BridgeGameTest {
    @Test
    void move_True_SameBridgeStateUserInput() {
        BridgeGame bridgeGame = new BridgeGame();
        boolean move = bridgeGame.move("U", "U");
        assertTrue(move);
    }

    @Test
    void move_False_DifferentBridgeStateUserInput() {
        BridgeGame bridgeGame = new BridgeGame();
        boolean move = bridgeGame.move("D", "U");
        assertFalse(move);
    }
}