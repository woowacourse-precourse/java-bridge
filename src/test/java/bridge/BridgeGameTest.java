
package bridge;

import bridge.BridgeGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BridgeGameTest {
    @DisplayName("이동할 수 있을 때 true를 반환한다.")
    @Test
    void createMovable() {
        BridgeGame bridgeGame = new BridgeGame();
        boolean move = bridgeGame.move("U", "U");
        assertTrue(move);
    }

    @DisplayName("이동할 수 없을 때 false를 반환한다.")
    @Test
    void createUnMovable() {
        BridgeGame bridgeGame = new BridgeGame();
        boolean move = bridgeGame.move("D", "U");
        assertFalse(move);
    }
}