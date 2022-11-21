package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    @Test
    void matchNext() {
        List<String> bridge = List.of("U", "U", "U");
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.match("U");
        assertEquals(true, bridgeGame.match("U"));
        assertEquals(false, bridgeGame.match("D"));
    }
}