package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    @Test
    void move() {
        List<String> bridge = List.of("U", "U", "U");
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move("U");
        assertEquals(true, bridgeGame.move("U"));
        assertEquals(false, bridgeGame.move("D"));
    }
}