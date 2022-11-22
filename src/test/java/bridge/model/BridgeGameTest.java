package bridge.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeGameTest {

    @DisplayName("Test whether user can make a proper size bridge")
    @ParameterizedTest
    @ValueSource(ints = {4, 7, 10})
    void bridgeFromUserInput(Integer input) {
        BridgeGame bridgeGame = new BridgeGame(input);
        assertEquals(input, bridgeGame.getBridge().size());
    }

    @DisplayName("Test whether user can make a proper move on bridge")
    @Test
    void move() {
        BridgeGame bridgeGame = new BridgeGame(4);
        bridgeGame.move("U");
        assertEquals(1, bridgeGame.getCurrentPosition());
    }

    @DisplayName("Test whether user can make a proper try count")
    @Test
    void retry() {
        BridgeGame bridgeGame = new BridgeGame(4);
        bridgeGame.move("U");
        bridgeGame.retry("R");
        assertEquals(2, bridgeGame.getTryCount());
    }

    @DisplayName("Test whether user can make a proper game over situation")
    @Test
    void isGameOver() {
        BridgeGame bridgeGame = new BridgeGame(4);
        bridgeGame.move("D");
        assertFalse(bridgeGame.isGameOver());
    }
}